package com.cml.springboot.framework.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
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

	// private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String token = request.getParameter(TOKEN_NAME);

		if (StringUtils.isNotBlank(token)) {
			// 1、TODO 获取用户信息

			return true;
		}
		// TODO 输出
		writeInvalidAccess(response);

		return false;
	}

	private void writeInvalidAccess(HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		mapper.writeValue(response.getOutputStream(), "不许你访问");
	}

}
