package com.cml.springboot.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cml.springboot.framework.Configuration;
import com.cml.springboot.framework.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * token 校验
 * 
 * @author team-lab
 *
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
	private static final String TOKEN_NAME = "token";

	protected static Log LOG = LogFactory.getLog(TokenInterceptor.class);

	// private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String token = request.getParameter(TOKEN_NAME);

		LOG.info("<<token>>请求url:" + request.getRequestURL());

		if (StringUtils.isNotBlank(token)) {
			// 1、TODO 获取用户信息

			return true;
		}
		// TODO 输出
		writeInvalidAccess(response);

		return false;
	}

	private void writeInvalidAccess(HttpServletResponse response) throws Exception {
		LOG.info("<<<无效的token>>>");
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		// Include.Include.ALWAYS 默认
		// Include.NON_DEFAULT 属性为默认值不序列化
		// Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
		// Include.NON_NULL 属性为NULL 不序列化
		mapper.setSerializationInclusion(Include.NON_NULL);
		BaseResponse responseBean = new BaseResponse(Configuration.Status.STATUS_INVALID_TOKEN, "invalid token!");
		mapper.writeValue(response.getWriter(), responseBean);
	}

}
