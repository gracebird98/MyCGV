package com.mycgv_jsp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mycgv_jsp.vo.SessionVo;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter {
	/*
	 * preHandle
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
		//클라이언트(브라우저)의 요청 확인 - 세션 객체 가져오기
		HttpSession session = request.getSession();
		
		//sid 확인하기
		//String sid = (String)session.getAttribute("sid");
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		if(svo == null) {
			//로그인 안되어 있는 상태이므로 로그인 폼으로 전송
			response.sendRedirect("/mycgv_jsp/login.do");
			return false;
		}
		return true;
	}
}
