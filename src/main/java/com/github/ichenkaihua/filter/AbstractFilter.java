package com.github.ichenkaihua.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class AbstractFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String menthod = request.getMethod();

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		
		
/*		System.out.println("requestUri: " + requestUri);
		System.out.println("contextPath: " + contextPath);
		System.out.println("url: " + url);*/
		
		doFilter(request, response, chain, session, menthod, url);

	}

	/**
	 * 
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @param session
	 *            session 可能为空
	 * @param menthod
	 *            menthod
	 * @param url
	 *            url
	 */
	public abstract void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			HttpSession session, String menthod, String url)
			throws IOException, ServletException;

}
