package com.ird.portal.web.interceptor;

import com.ird.portal.user.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocaleInterceptor extends LocaleChangeInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LocaleInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {

		Locale userLocale = UserContext.getUserLocale();

		if (userLocale != null) {
			Locale sessionLocale = (Locale) WebUtils.getSessionAttribute(request,
					SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);

			Locale processLocale = processLocale(userLocale);
			logger.info("sessionLocale: {}, processLocale: {}", sessionLocale, processLocale);

			// if session locale is null or is changed, then reset it
			if (sessionLocale == null || !processLocale.equals(sessionLocale)) {
				sessionLocale = processLocale;
				LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
				localeResolver.setLocale(request, response, sessionLocale);
			}
		}

		return true;

	}

	/**
	 * null -> en , zh_TW -> zh_TW , other -> en
	 *
	 * @param locale
	 * @return
	 */
	private Locale processLocale(Locale locale) {
		if (locale != null) {
			if (Locale.ENGLISH.getLanguage().equals(locale.getLanguage())) {
				return Locale.ENGLISH;
			} else {
				return Locale.TRADITIONAL_CHINESE;
			}
		} else {
			return Locale.ENGLISH;
		}
	}

}
