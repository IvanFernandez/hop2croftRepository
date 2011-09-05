package com.hopcroft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeResponseInterceptor extends HandlerInterceptorAdapter {
	private long TIMESLEPT = 100L;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		long starRequestTime = System.currentTimeMillis();
		request.setAttribute("startRequestTime", starRequestTime);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startRequestTime = (Long) request.getAttribute("startRequestTime");
//		Thread.sleep(TIMESLEPT);
		long endRequestTime = System.currentTimeMillis();
		modelAndView.addObject("timeResponse", endRequestTime - startRequestTime);
	}


}
