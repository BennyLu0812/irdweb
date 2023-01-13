/**
 * @Project Name: dls-common-web
 * @File Name: AuthenticationInterceptor.java
 * @Package Name: mo.gov.dsat.web.interceptor
 * @Date: 2017年11月10日 下午12:49:20
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.interceptor;

import com.ird.portal.common.user.service.UserServiceApi;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.web.security.annotion.NeedApiLogin;
import com.ird.portal.web.security.annotion.NotLogin;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;


/**
 *
 * 用戶賬號信息認證攔截器.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/12/2017 18:04:47<br/>
 *
 * @author Jim
 * @version 1.0
 */
public class AuthenticationInterceptor extends AbstractHandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

	@Autowired
	private UserServiceApi userServiceApi;


	@Value("${website.model}")
	private String websiteModel;

	@Override
	public boolean preHandleTwo(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// NotLogin注解不進行登錄攔截
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			NotLogin notLogin = handlerMethod.getMethodAnnotation(NotLogin.class);
			if (notLogin != null) {
				return true;
			}
		}

		//判斷API是否需要進行對外API的登錄驗證
		boolean isNeedApiLogin = false;
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			NeedApiLogin needApiLogin = handlerMethod.getMethodAnnotation(NeedApiLogin.class);
			if (needApiLogin != null) {
				isNeedApiLogin = true;
			}
		}

		request.setAttribute("$websiteModel$", websiteModel);
		String redirectUrl = null;

		if(request.getQueryString() != null && request.getQueryString().indexOf("redirect") > 0){
			redirectUrl = request.getRequestURI()+"?"+request.getQueryString();
		}

		HttpSession session = request.getSession();

		// 判斷用戶信息是否在session中存在
		User currentUser = session != null ? (User)session.getAttribute(UserContext.USER_SESSION) : null;
		if (logger.isInfoEnabled()) {
			String userId = currentUser!=null ? currentUser.getUserId() : null;
			String sessionId = session != null ? session.getId() : null;
			String requestUri = request.getRequestURI();
			logger.info("intercept userId :{},sessionId:{},requestUri:{}", userId, sessionId,requestUri);
		}
		if (currentUser == null) {
			if (StringUtils.equalsIgnoreCase("XMLHttpRequest", request.getHeader("X-Requested-With"))) {
				response.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);
				response.setHeader("ajaxErrorFlag", "timeout");
			}else{
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.sendError(HttpServletResponse.SC_FORBIDDEN);

				if (isNeedApiLogin){
					//當用戶為空且需要進行對外API的登錄驗證，屬於則返回字符串
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					ServletOutputStream out = response.getOutputStream();
					try(OutputStreamWriter ow = new OutputStreamWriter(out, "UTF-8")){
						ow.write("{\"result\":\"403\", \"resultMsg\":\"請先登錄後再試\"}");
						ow.flush();
						ow.close();
					} catch (Exception e) {
						return false;
					}
				}else{
					String param = "";
					if(redirectUrl != null ){
						param = "?param="+URLEncoder.encode(redirectUrl,"UTF-8");
					}
					response.sendRedirect(request.getContextPath()+"/login/login.html"+param);
				}
			}
			return false;
		}
		UserContext.setUser(currentUser);





		response.setHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "must-revalidate");
		response.setDateHeader("Expires", 0);
		return true;
	}

	/**
	 *
	 * workaroud for weblogic bug use Accept-Lanuguage as requestedlocale if it is
	 * not null Only get first locale if Accept-Lanuguage is not parsable, use
	 * request.getLocale() directly
	 *
	 * @param request
	 * @
	 */
	public Locale resolveLocale(HttpServletRequest request) {
		Locale requestLocale = request.getLocale();

		String acceptLang = request.getHeader("Accept-Language");
		try {
			List<LanguageRange> parsedAcceptLanguageList = Locale.LanguageRange.parse(acceptLang);
			if (CollectionUtils.isNotEmpty(parsedAcceptLanguageList)) {
				LanguageRange lr = parsedAcceptLanguageList.get(0);
				Locale localeFromAcceptLanguage = Locale.forLanguageTag(lr.getRange());
				if (localeFromAcceptLanguage != null) {
					requestLocale = localeFromAcceptLanguage;
				}
			}
		} catch (Exception e) {
			logger.debug("Exception : {}", e.getMessage());
		}

		logger.debug("request.getLocale() locale:{} Accept-Language:{}, usedLocale:{}", request.getLocale(), acceptLang,
				requestLocale);
		return requestLocale;
	}

}
