package com.ird.portal.audit;


import com.ird.portal.audit.annotation.AuditGroupBy;
import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.audit.annotation.NotAudited;
import com.ird.portal.entity.IEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.*;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * Audit Log Listener is used to log insert, update, and delete operations. Complete list of listeners/events can be
 * obtained at <tt>org.hibernate.event.EventListeners</tt>.
 */
@Component
public class AuditEventListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {

    /**
     *
     */
    private static final long    serialVersionUID = 1633049125406568669L;

    private static final Logger  LOGGER           = LoggerFactory.getLogger(AuditEventListener.class);

    private static final String  DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private static final String ROLE_FUNC_TABLE_NAME = "CLP_SYS_ROLE_FUNC";

    private static final String USER_ROLE_TABLE_NAME = "" +
            "CLP_SYS_USER_ROLE";

    private static final String PROPERTY_ROLE_ID = "roleId";

    private static final String PROPERTY_USER_ID = "userId";

    private static final String PROPERTY_FUNC_ID = "funcId";

    /**
     * 初始化， 注冊Hibernate的INSERT,UPDATE,DELETE事件監聽.
     */
    @PostConstruct
    private void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(this);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(this);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(this);

    }

    /**
     * @see PostInsertEventListener#onPostInsert(PostInsertEvent)
     */
    @Override
    public void onPostInsert(PostInsertEvent event) {

//        LOGGER.debug("onPostInsert."+event.getEntity().toString());

        auditEvent(event
                .getSession(), event.getPersister(), Action.I, event.getId(), event.getEntity(), null, event.getState());
    }

    /**
     * @see PostUpdateEventListener#onPostUpdate(PostUpdateEvent)
     */
    @Override
    public void onPostUpdate(PostUpdateEvent event) {

//        LOGGER.debug("onPostUpdate."+event.getEntity().toString());
        auditEvent(event.getSession(),
                event.getPersister(),
                Action.U,
                event.getId(),
                event.getEntity(),
                event.getOldState(),
                event.getState());
    }

    /**
     * @see PostDeleteEventListener#onPostDelete(PostDeleteEvent)
     */
    @Override
    public void onPostDelete(PostDeleteEvent event) {
        auditEvent(event.getSession(),
                event.getPersister(),
                Action.D,
                event.getId(),
                event.getEntity(),
                event.getDeletedState(),
                null);
    }

    private void auditEvent(
            EventSource source, EntityPersister entityPersister, Action action, Serializable entityId, Object entity,
            Object[] oldState, Object[] newState) {

        if (isAudited()) {
            try {
                Class<?> entityClass = entity.getClass();
                if (isAudited(entityClass)) {
                    final AuditEntry auditEntry = createAuditEntry(action,
                            entityId.toString(),
                            entityPersister.getEntityName(),
                            getTableName(entityClass),
                            entity);

                    if (auditEntry.getTableName().equals(ROLE_FUNC_TABLE_NAME) || auditEntry.getTableName().equals(USER_ROLE_TABLE_NAME)) {
                        this.addAuditFieldsWithSpecialTable(auditEntry, oldState, newState, entityClass, action);
                    } else {
                        String[] propertyNames = entityPersister.getPropertyNames();
                        if (!ObjectUtils.isEmpty(propertyNames)) {
                            addAuditFields(auditEntry, propertyNames, oldState, newState, entityClass, action);
                        }
                    }

                    if (CollectionUtils.isNotEmpty(auditEntry.getAuditFields())) {
                        AuditProcessManager.getInstance().registerProcess(source).add(auditEntry);
                    }
                }
            }
            catch (Exception e) {
                LOGGER.error("Error get entity info.", e);
            }
        }
    }

    /**
     * 特殊處理SYS_ROLE_FUNC和CLP_SYS_USER_ROLE兩張表
     * @param auditEntry
     * @param oldState
     * @param newState
     * @param entityClass
     * @param action
     */
    private void addAuditFieldsWithSpecialTable(final AuditEntry auditEntry, final Object[] oldState, final Object[] newState,
                                                final Class<?> entityClass, final Action action) {
        String[] entityIds;
        if (auditEntry.getTableName().equals(ROLE_FUNC_TABLE_NAME)) {
            entityIds = new String[]{PROPERTY_ROLE_ID, PROPERTY_FUNC_ID};
        } else {
            entityIds = new String[]{PROPERTY_ROLE_ID, PROPERTY_USER_ID};
        }
        Object[] oldObj = null;
        Object[] newObj = null;
        if (oldState != null) {
            oldObj = String.valueOf(oldState[0]).split(",");
        }
        if (newState != null) {
            newObj = String.valueOf(newState[0]).split(",");
        }
        addAuditFields(auditEntry, entityIds, oldObj, newObj, entityClass, action);
    }

    private AuditEntry createAuditEntry(
            Action action, String entityId, String entityName, String tableName, Object entity) {
        AuditEntry auditEntry = new AuditEntry();

        // 將目標Entity的屬性複製至AuditIndex中，一般地，目標Entity會包含一些業務相關的字段，
        // 如docId, docSeq, licType, licCode, examYear, examNo等等，因此可以將這些屬性的值部份複製至AuditIndex。
        BeanUtils.copyProperties(entity, auditEntry);
        auditEntry.setAction(action);
        auditEntry.setEntityId(entityId);
        auditEntry.setEntityName(entityName);
        auditEntry.setTableName(tableName);
        AuditContext auditContext = AuditContext.getInstance();
        // Try to use spNo in AuditContext when spNo in entity is null
        // TODO
        return auditEntry;
    }

    private void addAuditFields(
            AuditEntry auditEntry, String[] propertyNames, Object[] oldState, Object[] newState, Class<?> entityClass,
            Action action) {
        boolean isUpdate = (Action.U == action);
        for (int i = 0; i < propertyNames.length; i++) {
            PropertyDescriptor descriptor = getPropertyDescriptor(entityClass, propertyNames[i]);
            if (descriptor != null) {
                Method method = descriptor.getReadMethod();
                if (method == null || isNotAudited(method) || isCollection(method)) {
                    continue;
                }
                // @AuditGroupBy
                boolean isAuditGroupBy = isAuditGroupBy(method);
                if (isAuditGroupBy && !AuditContext.getInstance().isAuditGroupBy()) {
                    AuditContext.getInstance().setAuditGroupBy(true);
                }
                Object oldValue = (oldState != null) ? oldState[i] : null;
                Object newValue = (newState != null) ? newState[i] : null;
                String columnName = null;
                JoinColumn joinColumn = getJoinColumn(method);
                if (joinColumn != null) { // ManyToOne
                    if (oldValue instanceof IEntity) {
                        oldValue = ((IEntity)oldValue).getId();
                    }
                    if (newValue instanceof IEntity) {
                        newValue = ((IEntity)newValue).getId();
                    }
                    columnName = joinColumn.name();
                } else {
                    Column column = getColumn(method);
                    if (column != null) {
                        if (isUpdate && !column.updatable()) {
                            continue;
                        }
                        columnName = column.name();
                    }
                }
                if (isNotChanged(oldValue, newValue) || StringUtils.isEmpty(columnName)) {
                    continue;
                }
                auditEntry.addAuditField(createAuditField(propertyNames[i],
                        columnName,
                        getValue(oldValue),
                        getValue(newValue),
                        isAuditGroupBy));
            }
        }
    }

    private AuditField createAuditField(
            String propertyName, String columnName, Object oldValue, Object newValue, boolean auditGroupBy) {
        return new AuditField(propertyName, columnName, getValue(oldValue), getValue(newValue), auditGroupBy);
    }

    private boolean isAudited() {
        AuditContext auditContext = AuditContext.getInstance();
        boolean isAudited = StringUtils.isNotBlank(auditContext.getUserId()) && StringUtils.isNotBlank(auditContext.getFuncCode())
                && auditContext.isAudited();
        return isAudited;
    }

    private static PropertyDescriptor getPropertyDescriptor(Class<?> entityClass, String propertyName) {
        return BeanUtils.getPropertyDescriptor(entityClass, propertyName);
    }

    private static boolean isCollection(Method method) {
        return Collection.class.isAssignableFrom(method.getReturnType());
    }

    private static boolean isNotChanged(Object oldValue, Object newValue) {
        if (oldValue == newValue) {
            return true;
        }
        if (oldValue == null) {
            return StringUtils.isBlank(newValue.toString());
        }
        if (newValue == null) {
            return StringUtils.isBlank(oldValue.toString());
        }
        if (oldValue instanceof Date && newValue instanceof Date) {
            return DateUtils.truncatedEquals((Date)oldValue, (Date)newValue, Calendar.SECOND);
        }
        return (StringUtils.isBlank(oldValue.toString()) && StringUtils.isBlank(newValue.toString()))
                || Objects.equals(oldValue, newValue);
    }

    private static String getValue(Object value) {
        if (value == null) {
            return null;
        }

        if( value instanceof String && ((String)value).length() > 4000 ) {
            return null;
        }

        if (value instanceof Date) {
            return DateFormatUtils.format((Date)value, DATETIME_PATTERN);
        }
        return value.toString();
    }

    private static String getTableName(Class<?> entityClass) {
        return entityClass.getAnnotation(Table.class).name();
    }

    private static JoinColumn getJoinColumn(Method method) {
        return method.getAnnotation(JoinColumn.class);
    }

    private static Column getColumn(Method method) {
        return method.getAnnotation(Column.class);
    }

    private static boolean isAudited(Class<?> entityClass) {
        return entityClass.isAnnotationPresent(Audited.class);
    }

    private static boolean isNotAudited(Method method) {
        return method.isAnnotationPresent(NotAudited.class);
    }

    /**
     * 檢查實體的get方法上是否存在 AuditGroupBy.
     *
     * @param method
     * @return
     */
    private static boolean isAuditGroupBy(Method method) {
        return method.isAnnotationPresent(AuditGroupBy.class);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.event.spi.PostInsertEventListener#requiresPostCommitHanding(org.hibernate.persister.entity.
     * EntityPersister)
     */
    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        // TODO Auto-generated method stub
        return false;
    }
}
