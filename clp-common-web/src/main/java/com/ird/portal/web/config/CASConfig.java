/**
 * @Project Name: dls-common-web
 * @File Name: CASConfig.java
 * @Date: 2017年11月9日 上午11:16:17
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.boot.web.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.boot.web.filter.OrderedHttpPutFormContentFilter;
import org.springframework.boot.web.filter.OrderedRequestContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

//import org.jasig.cas.client.session.SingleSignOutFilter;
//import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;

/**
 * 
 * CAS 配置.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/12/2017 15:02:20<br/>
 * 
 * @author Jim
 * @version 1.0
 */
@Configuration
public class CASConfig {

	public static final String separator = ",";

	/**
	 * 用於是否啟用CAS
	 */
	@Value("${cas.casEnabled}")
	private boolean casEnabled;

	@Value("${cas.isWeblogic}")
	private boolean isWeblogic;


	/**
	 * Spring Boot 内置的tomcat與Weblogic 12c上的順序是相反的，Weblogic數值越大，優先級越高，同Tomcat相反. 重新定義
	 * errorPageFilter、characterEncodingFilter的順序.
	 * 
	 * https://stackoverflow.com/questions/38162416/spring-boot-filter-order-weblogic-12c-vs-tomcat-8
	 * https://github.com/spring-projects/spring-boot/issues/2643
	 */
	private static final int WEBLOGIC_FILTER_ORDER_INDEX_FINAL = 11;
	private static int TOMCAT_FILTER_ORDER_INDEX = 1;
	private static int WEBLOGIC_FILTER_ORDER_INDEX = WEBLOGIC_FILTER_ORDER_INDEX_FINAL;

	private int getFilterOrder() {
		return isWeblogic ? WEBLOGIC_FILTER_ORDER_INDEX-- : TOMCAT_FILTER_ORDER_INDEX++;
	}

	@Bean("errorPageFilter")
	// @Order(11)
	public FilterRegistrationBean errorPageFilter() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		ErrorPageFilter errorPageFilter = new ErrorPageFilter();
		filterRegistration.setFilter(errorPageFilter);
		filterRegistration.setEnabled(true);
		filterRegistration.setName("errorPageFilter");
		filterRegistration.setOrder(getFilterOrder());
		return filterRegistration;
	}

	@Bean("characterEncodingFilter")
	public FilterRegistrationBean characterEncodingFilter(OrderedCharacterEncodingFilter characterEncodingFilter) {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(characterEncodingFilter);
		filterRegistration.setEnabled(true);
		filterRegistration.setName("characterEncodingFilter");
		int order = getFilterOrder();
		filterRegistration.setOrder(order);
		characterEncodingFilter.setOrder(order);
		return filterRegistration;
	}

	@Bean("hiddenHttpMethodFilter")
	public FilterRegistrationBean hiddenHttpMethodFilter(OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter) {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(hiddenHttpMethodFilter);
		filterRegistration.setEnabled(true);
		filterRegistration.setName("hiddenHttpMethodFilter");
		int order = getFilterOrder();
		filterRegistration.setOrder(order);
		hiddenHttpMethodFilter.setOrder(order);
		return filterRegistration;
	}

	@Bean("httpPutFormContentFilter")
	public FilterRegistrationBean httpPutFormContentFilter(OrderedHttpPutFormContentFilter httpPutFormContentFilter) {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(httpPutFormContentFilter);
		filterRegistration.setEnabled(true);
		filterRegistration.setName("httpPutFormContentFilter");
		int order = getFilterOrder();
		filterRegistration.setOrder(order);
		httpPutFormContentFilter.setOrder(order);
		return filterRegistration;
	}

	@Bean("requestContextFilter")
	public FilterRegistrationBean requestContextFilter(OrderedRequestContextFilter requestContextFilter) {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(requestContextFilter);
		filterRegistration.setEnabled(true);
		filterRegistration.setName("requestContextFilter");
		int order = getFilterOrder();
		filterRegistration.setOrder(order);
		requestContextFilter.setOrder(order);
		return filterRegistration;
	}


	private String getServerHostName() throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		String serverHostName = localHost.getHostName();
		System.out.println("ServerHostName: " + serverHostName);
		return serverHostName;
	}

}
