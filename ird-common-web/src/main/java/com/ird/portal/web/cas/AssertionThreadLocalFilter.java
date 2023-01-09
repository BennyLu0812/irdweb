/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.ird.portal.web.cas;

import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Places the assertion in a ThreadLocal such that other resources can access it that do not have access to the web tier session.
 *
 * @author Scott Battaglia
 * @version $Revision: 11728 $ $Date: 2007-09-26 14:20:43 -0400 (Tue, 26 Sep 2007) $
 * @since 3.0
 */
public final class AssertionThreadLocalFilter implements Filter {

    /** Instance of commons logging for logging purposes. */
    private final Logger log = LoggerFactory.getLogger(getClass());
    
    public void init(final FilterConfig filterConfig) throws ServletException {
        // nothing to do here
    }

    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
            final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpSession session = request.getSession(false);
        final Assertion assertion = (Assertion) (session == null ? request
                .getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION) : session
                .getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION));
        
        if (isUrlExcluded(request.getRequestURI())) {
            if (log.isInfoEnabled()) {
                log.info("isUrlExcluded::{}", isUrlExcluded(request.getRequestURI()));
            }
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        
        try {
            AssertionHolder.setAssertion(assertion);
            User user = new User();
            String name = assertion.getPrincipal().getName();
            name = StringUtils.upperCase(name);
            user.setUserId(name);
            user.setUserName(name);
            UserContext.setUser(user);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            AssertionHolder.clear();
        }
    }

    public void destroy() {
        // nothing to do
    }
    
    
    
    protected List<String> excludeUrls;
    
    public List<String> getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    public final Boolean isUrlExcluded(String url) {
        for (String excludeUrl : this.excludeUrls) {
            if (StringUtils.contains(url, excludeUrl)) {
                return true;
            }
        }
        return false;
    }
}
