package com.ird.portal.config;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Data Source 的配置.
 * 
 * @author Jim
 * @since Aug 22, 2017 8:28:17 PM
 */
@Configuration
public class DataSourceConfig {

	private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	@Value("${spring.datasource.mode}")
	private String mode;

	@Bean(name = "dataSource",destroyMethod = "")
	@Primary //標記為主要數據源
	public DataSource dataSource() {
		if ("JDBC".equals(mode)) {
			return dataSourceJDBC();
		}
		if ("JNDI".equals(mode)) {
			return dataSourceJNDI();
		}
		return null;
	}

	/*************************
	 * Spring JDBC BEGIN
	 ************************************/

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	@Value("${spring.datasource.initialSize}")
	private int initialSize;

	@Value("${spring.datasource.minIdle}")
	private int minIdle;

	@Value("${spring.datasource.maxActive}")
	private int maxActive;

	@Value("${spring.datasource.maxWait}")
	private int maxWait;

	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;

	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${spring.datasource.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${spring.datasource.testOnReturn}")
	private boolean testOnReturn;

	@Value("${spring.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Value("${spring.datasource.filters}")
	private String filters;

	@Value("{spring.datasource.connectionProperties}")
	private String connectionProperties;

	/**
	 * JDBC方式獲取.
	 * 
	 * @return
	 */
	private DataSource dataSourceJDBC() {
		DruidDataSource datasource = new DruidDataSource();

		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);

		// configuration
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setValidationQuery(validationQuery);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		datasource.setPoolPreparedStatements(poolPreparedStatements);
		datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		try {
			datasource.setFilters(filters);
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		datasource.setConnectionProperties(connectionProperties);
		return datasource;
	}

	/*************************
	 * Spring JDBC END
	 ************************************/

	/*************************
	 * Spring JNDI BEGIN
	 ************************************/

	@Value("${spring.datasource.jndi.name}")
	private String jndiName;

	private DataSource dataSourceJNDI() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setJndiName(jndiName);
		try {
			jndiObjectFactoryBean.afterPropertiesSet();
		} catch (NamingException e) {
			logger.error("Error while retrieving datasource with JNDI name " + jndiName, e);
		}
		return (DataSource) jndiObjectFactoryBean.getObject();
	}

	/*************************
	 * Spring JNDI END
	 ************************************/

}
