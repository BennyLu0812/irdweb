package com.ird.portal.dao.hibernate;

import com.ird.portal.dao.DAO;
import com.ird.portal.dao.DaoCmd;
import com.ird.portal.exception.DatabaseException;
import com.ird.portal.exception.ErrorMessageHelper;
import com.ird.portal.exception.SysException;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;



/**
 * @author Jim
 * @since 14/12/2016 下午9:49
 */
public abstract class HibernateDAO implements DAO {
    private static final Logger logger = LoggerFactory.getLogger(HibernateDAO.class);

    /**
     * sql 的类型，hql 和 sql.
     */
    protected static final String HQL = "hql";
    protected static final String SQL = "sql";
    protected static final String TYPE = "[@type]";

    private Configuration FREEMARKER;

    private Map<String, String> queryFileKeyMap;

    protected abstract EntityManager getEntityManager();

    /**
     * 设置自己业务需要的方法，这个需要自己业务实现类处定义，如果没有需要，不处理即可.
     *
     * @param obj
     * @return
     */
    protected abstract Object setCustomerInfo(Object obj);

    public Object insert(Object obj) {
    	try {
            setCustomerInfo(obj);
            getEntityManager().persist(obj);
            return obj;
    	} catch (Exception ex) {
    		throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_INSERT, ex.getMessage()), ex);
    	}
    }
    
    public Object insertExcludeCustomerInfo(Object obj) {
        try {
            getEntityManager().persist(obj);
            return obj;
        } catch (Exception ex) {
            throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_INSERT, ex.getMessage()), ex);
        }
    }

    @Override
    public Object update(Object obj) {
    	try {
    		setCustomerInfo(obj);
    		return getEntityManager().merge(obj);
    	} catch (Exception ex) {
    		throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_UPDATE, ex.getMessage()), ex);
    	}
    }

    @Override
    public void delete(Object obj) {
    	try {
            getEntityManager().remove(getEntityManager().merge(obj));    		
    	} catch (Exception ex) {
    		throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_DELETE, ex.getMessage()), ex);
    	}
    }

    @Override
    public <T extends Serializable> T getSingle(Class<T> entityClass, Object primaryKey) {
    	try {
            return getEntityManager().find(entityClass, primaryKey);    		
    	} catch (Exception ex) {
    		throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_GET_SINGLE, ex.getMessage()), ex);
    	}
    	
    }

    @SuppressWarnings({ "unchecked" })
    public <T> T getSingle(DaoCmd cmd, Class<?> resultType, ResultTransformer transformer) {
    	try {
            Query query = createQuery(cmd, resultType);
            if (transformer != null) {
                query.setResultTransformer(transformer);
            }

            return (T) query.uniqueResult();    		
    	} catch (Exception ex) {
    		throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_GET_SINGLE, ex.getMessage()), ex);
    	}
    }

    @Override
    public <T> T getSingle(DaoCmd cmd, Class<?> resultType, boolean aliasToBean) {
    	return getSingle(cmd, resultType, aliasToBean ? getTransformerAdapter(resultType) : null);    		
    }

    @Override
    public <T> T getSingle(DaoCmd cmd, Class<?> resultType) {
    	return getSingle(cmd, resultType, null);    		
    }

    @SuppressWarnings({  "unchecked" })
    @Override
    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult, Integer startFrom, ResultTransformer transformer) {
    	try {
            Query query = createQuery(cmd, resultType);
            if (maxResult != null) {
                query.setMaxResults(maxResult);
            }
            if (startFrom != null) {
                query.setFirstResult(startFrom);
            }
            if (transformer != null) {
                query.setResultTransformer(transformer);
            }
            return query.list();    		
    	} catch (Exception ex) {
    		throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_GET_LIST, ex.getMessage()), ex);
    	}
    }

    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult, ResultTransformer transformer) {
    	return getList(cmd, resultType, maxResult, null, transformer);    		
    }

    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, ResultTransformer transformer) {
    	return getList(cmd, resultType, null, null, transformer);	
    }

    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult) {
            return getList(cmd, resultType, maxResult, null, null);    		
    }

    @Override
    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult, Integer startFrom) {
    	return getList(cmd, resultType, maxResult, startFrom, null);	
    }

    @Override
    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType) {
    	return getList(cmd, resultType, null, null, null);	
    }
    
    @Override
    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, boolean aliasToBean) {
    	return getList(cmd, resultType, null, null, aliasToBean);	
    }

    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult, Integer startFrom, boolean aliasToBean) {
    	return getList(cmd, resultType, maxResult, startFrom, aliasToBean ? getTransformerAdapter(resultType) : null);	
    }

    public <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult, boolean aliasToBean) {
    	return getList(cmd, resultType, maxResult, null, aliasToBean);	
    }


    /**
     * 将class转换为ResultTransformer.
     *
     * @param clazz
     * @return
     */
    @SuppressWarnings("rawtypes")
    public ResultTransformer getTransformerAdapter(Class clazz) {
        return Map.class.isAssignableFrom(clazz) ? Transformers.ALIAS_TO_ENTITY_MAP : BeanTransformerAdapter.newInstance(clazz);
    }

    protected <T> Query createQuery(DaoCmd cmd, Class<?> resultType) {
        Session session = getSession();
        String queryType = getQueryType(cmd);
        if (queryType == null) {
            queryType = HQL;
        }

        Query query;
        if (HQL.equals(queryType)) {

            String queryString = processTemplate(cmd);

            if (StringUtils.isNotBlank(cmd.getOrderString())) {
                if (StringUtils.contains(queryString.toLowerCase(), " order ")) {
                    queryString = queryString + "," + cmd.getOrderString();
                } else {
                    queryString = queryString + " order by " + cmd.getOrderString();
                }
            }
            query = session.createQuery(queryString);

        } else if (SQL.equals(queryType)) {

            String queryString = processTemplate(cmd);
            if (StringUtils.isNotBlank(cmd.getOrderString())) {
                if (StringUtils.contains(queryString.toLowerCase(), " order ")) {
                    queryString = queryString + "," + cmd.getOrderString();
                } else {
                    queryString = queryString + " order by " + cmd.getOrderString();
                }
            }
            query = session.createSQLQuery(queryString);
        } else {
            throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_UNKOWN_QUERY_TYPE, queryType));
        }

        Map<String,Object> params = cmd.getParams();
        if (MapUtils.isNotEmpty(params)) {
            query.setProperties(params);
        }
        return query;
    }

    /**
     * FreeMarker Template Process
     */
    protected String processTemplate(DaoCmd cmd) {
        String queryKey = buildQueryKeyType(cmd);

        try {
            StringWriter writer = new StringWriter();
            FREEMARKER.getTemplate(queryKey).process(cmd.getParams(), writer);
            return writer.toString();
        } catch (Exception e) {
            logger.error("freemarker get template is error", e);
            logger.error("freemarker template loader info:" + FREEMARKER.getTemplateLoader().toString());
            throw new SysException("An exception occurred while processing the query template: ", e);
        }
    }

    @Override
    public int execute(DaoCmd cmd) {
    	try {
            String queryType = getQueryType(cmd);
            if (queryType == null) {
                queryType = HQL;
            }

            String queryString = processTemplate(cmd);

            Session session = getSession();
            Query query;
            if (HQL.equals(queryType)) {
                query = session.createQuery(queryString);
            } else if (SQL.equals(queryType)) {
                query = session.createSQLQuery(queryString);
            } else {
            	throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_EXECUTE, 
            			ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_UNKOWN_QUERY_TYPE, queryType)));
            }
            if (MapUtils.isNotEmpty(cmd.getParams())) {
                query.setProperties(cmd.getParams());
            }
            return query.executeUpdate();
    	} catch (Exception ex) {
    		if (ex instanceof DatabaseException) {
    			throw ex;
    		} else {
    			throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_EXECUTE, ex.getMessage()), ex);
    		}
    	}
    }

    protected final Session getSession() {
        return (Session) getEntityManager().getDelegate();
    }

    @Override
    public void flush() {
    	try {
    		getSession().flush();    		
    	} catch (Exception ex) {
    		throw new DatabaseException(ErrorMessageHelper.getErrorMessageWithCode(DatabaseException.ERROR_FLUSH, ex.getMessage()), ex);
    	}
    }

    public final synchronized void setQueryFiles(Resource[] queryFiles) {
        if (FREEMARKER == null) {
            FREEMARKER = new Configuration(Configuration.VERSION_2_3_23);
        }
        FREEMARKER.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        FREEMARKER.setDefaultEncoding(StandardCharsets.UTF_8.name());
        FREEMARKER.setNumberFormat("#"); // 避免數字格式化

        if (queryFileKeyMap == null) {
            queryFileKeyMap = new HashMap<>();
        }
        
        List<TemplateLoader> templateLoaderList = new ArrayList<>();
        URL url = null; 
        try {
            for (Resource resource : queryFiles) {
                Configurations configs = new Configurations();
                url = resource.getURL();
                XMLConfiguration xmlConfigs = configs.xml(url);
                xmlConfigs.setThrowExceptionOnMissing(false);

                TemplateLoader templateLoader = setTemplateLoader(xmlConfigs);
                templateLoaderList.add(templateLoader);
                logger.info("Add query file: {}", url);
            }
        } catch (IOException e) {
            logger.error("resource.getURL() is error.", e);
            throw new SysException("resource.getURL() is error.", e);
        } catch (ConfigurationException e) {
            logger.error(url+" 文件格式有错误.", e);
            throw new SysException(url+" 文件格式有错误.", e);
        }
        FREEMARKER.setTemplateLoader(new MultiTemplateLoader(templateLoaderList.toArray(new TemplateLoader[templateLoaderList.size()])));
        logger.info("template loader: {}", FREEMARKER.getTemplateLoader().toString());
    }

    /**
     * 初始化时，将xml的内容加载到StringTempLateLoadder中.
     *
     * @param queryFile
     */
    private TemplateLoader setTemplateLoader(XMLConfiguration queryFile) {
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        Iterator<String> iterators = queryFile.getKeys();
        while (iterators.hasNext()) {
            String queryKey = iterators.next();
            if (StringUtils.contains(queryKey, TYPE)) {
                continue;
            }
            String queryString = queryFile.getString(queryKey);
            String type = queryFile.getString(queryKey + TYPE);

            if (StringUtils.isBlank(queryString)) {
                queryString = StringUtils.EMPTY;
            }
            // queryKey + TYPE;
            String key = buildQueryKeyType(queryKey);
            queryFileKeyMap.put(key, type);
            stringTemplateLoader.putTemplate(key, queryString);
        }

        return stringTemplateLoader;
    }

    private String buildQueryKeyType(String queryKey) {
        return queryKey + TYPE;
    }

    private String buildQueryKeyType(DaoCmd cmd) {
        return buildQueryKeyType(cmd.getQueryKey());
    }

    protected String getQueryType(DaoCmd cmd) {
        String key = buildQueryKeyType(cmd);
        return queryFileKeyMap.get(key);
    }
}
