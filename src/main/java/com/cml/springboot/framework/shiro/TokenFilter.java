package com.cml.springboot.framework.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class TokenFilter extends AccessControlFilter {
	private static Log log = LogFactory.getLog(TokenFilter.class);

	protected String unauthorizedUrl;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {

		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getParameter("token");

		log.debug("=======>CookieAuthenticationFilter ,getUnauthorizedUrl=" + this.getUnauthorizedUrl() + ","
				+ mappedValue);

		if (StringUtils.isNotBlank(token)) {
			return true;
		}

		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		log.debug("=======>onAccessDenied :" + this.getUnauthorizedUrl());
		WebUtils.redirectToSavedRequest(request, response, getUnauthorizedUrl());
		return false;
	}

	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}

	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}

}
