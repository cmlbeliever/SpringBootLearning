package com.cml.springboot.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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
		

		return false;

		// JsonResultBean result = new JsonResultBean();
		// String token = getAccessUserToken();
		// TUserBean user = userService.getUserInfoByToken(token);
		//
		// if (null == user) {
		// Object action = invocation.getAction();
		// if (action instanceof APIBaseAction) {
		// APIBaseAction as = (APIBaseAction) action;
		// ReturnJsonUtil.otherOperate(result, Code.USER_NOT_FOUNT,
		// as.getText(I18nMessageKey.Common.USER_NOT_FOUNT));
		// invocation.getStack().set("result", result);
		// }
		// return "global_api_result";
		// }
		// invocation.getInvocationContext().getContextMap().put(BARCODE,
		// user.getBarcode());
	}

}
