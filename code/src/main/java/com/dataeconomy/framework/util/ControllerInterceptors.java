package com.dataeconomy.framework.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dataeconomy.workbench.constant.WBConstants;
public class ControllerInterceptors extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			AppUser principal = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			AppWebUtils.loadThreadLocalUtils(principal);
		}
		ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.X_TIMEZONE, request.getHeader(ThreadLocalUtil.X_TIMEZONE));
		if (request.getHeader(WBConstants.CURRENT_RELEASE) != null) {
			ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.CURRENT_RELEASE,
					new Integer(request.getHeader(WBConstants.CURRENT_RELEASE)));
		}
		return true;
	}

}