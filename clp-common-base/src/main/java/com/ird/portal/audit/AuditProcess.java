package com.ird.portal.audit;

import com.ird.portal.audit.entity.AuditDetailEntity;
import com.ird.portal.audit.entity.AuditIndexEntity;
import com.ird.portal.audit.entity.AuditMasterEntity;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.action.spi.BeforeTransactionCompletionProcess;
import org.hibernate.engine.spi.SessionImplementor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class AuditProcess implements BeforeTransactionCompletionProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditProcess.class);

//    private final LinkedList<AuditEntry> auditEntries;
    private final List<AuditEntry> auditEntries;

    public AuditProcess() {
//        auditEntries = new LinkedList<AuditEntry>();
        auditEntries = new ArrayList<AuditEntry>();
    }

    public AuditProcess add(AuditEntry auditEntry) {
        auditEntries.add(auditEntry);
        return this;
    }

    private void remove(AuditEntry auditEntry) {
        auditEntries.remove(auditEntry);
    }

    @Override
    public void doBeforeTransactionCompletion(SessionImplementor session) {
        try {
            if (FlushMode.isManualFlushMode(session.getFlushMode())) {
                Session temporarySession = null;
                try {
                    temporarySession = session.getFactory().openTemporarySession();
                    if (AuditContext.getInstance().isAuditGroupBy()) {
                        executeGroupBy(temporarySession);
                    } else {
                        execute(temporarySession, auditEntries);
                    }
                    temporarySession.flush();
                } finally {
                    if (temporarySession != null) {
                        temporarySession.close();
                    }
                }
            } else {
                if (AuditContext.getInstance().isAuditGroupBy()) {
                    executeGroupBy((Session) session);
                } else {
                    execute((Session) session, auditEntries);
                }

                session.flush();
            }
        } finally {
            auditEntries.clear();
        }
    }

    private void execute(Session session,List<AuditEntry> auditEntries) {
        try {
            
            AuditContext auditContext = AuditContext.getInstance();
            AuditMasterEntity auditMaster = new AuditMasterEntity(
                    auditContext.getFuncCode(),
                    auditContext.getUserId(),
                    new Date(),

                    auditContext.getHostIP(),
                    auditContext.getHostName(),
                    auditContext.getRemark()
            );
            session.save(auditMaster);

            for(AuditEntry auditEntry : auditEntries) {
                AuditIndexEntity auditIndex = new AuditIndexEntity(auditMaster);
                BeanUtils.copyProperties(auditEntry, auditIndex);
                auditIndex.setRowId(auditEntry.getEntityId());
                
                session.save(auditIndex);
                for (AuditField auditField : auditEntry.getAuditFields()) {
                    session.save(new AuditDetailEntity(
                            auditField.getColumnName(),
                            auditField.getValueBefore(),
                            auditField.getValueAfter(),
                            auditIndex
                    ));
                }
            }
            auditContext.setLogId(auditMaster.getId());
        } catch (Exception e) {
            LOGGER.error("Error insert audit log.", e);
        }
    }
    
    private void executeGroupBy(Session session){
        Map<String, List<AuditEntry>> groupByMap = new HashMap<>();
        for (AuditEntry auditEntry : auditEntries) {
            StringBuilder key = new StringBuilder("isAuditGroupBy");
            for (AuditField field : auditEntry.getAuditFields()) {
                if (field.isAuditGroupBy()) {
                    key.append(field.getPropertyName()).append(":").append(field.getValueAfter());
                }
            }
            if (groupByMap.containsKey(key.toString())) {
                groupByMap.get(key.toString()).add(auditEntry);
            } else {
                List<AuditEntry> newAuditEntries = new ArrayList<>();
                newAuditEntries.add(auditEntry);
                groupByMap.put(key.toString(), newAuditEntries);
            }
        }
        
        for(Map.Entry<String, List<AuditEntry>> entry:groupByMap.entrySet()){
            List<AuditEntry> auditEntries = entry.getValue();
            
            execute(session,auditEntries);
            
        }
        
    }

}
