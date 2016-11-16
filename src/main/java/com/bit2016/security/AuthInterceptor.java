package com.bit2016.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit2016.jblog.vo.UserVo;



public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler /*HandlerMethod*/)
			throws Exception {
		
		// 1. handler 종류
		if( handler instanceof HandlerMethod == false ) {
			return true;
		}
		
		// 2. @Auth 유무 체크
		Auth auth = ((HandlerMethod)handler).getMethodAnnotation(Auth.class);
		if( auth == null ) { //접근제어가 필요없는 핸들러
			return true;
		}
		
		//3. 접근제어 
		HttpSession session = request.getSession();
		if( session == null ) {
			response.sendRedirect(
					request.getContextPath() + "/jblog/user/loginform");
			return false;
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if( authUser == null ) {
			response.sendRedirect(
					request.getContextPath() + "/jblog/user/loginform");
			return false;
		}
		
		// 4. 인증된 사용자
		return true;
	}

}
