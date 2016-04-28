package com.github.ichenkaihua.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLogFilter extends AbstractFilter {

	private static Logger logger=null;

	public void init(FilterConfig config) {
		logger = LoggerFactory.getLogger(RequestLogFilter.class);
	}

	public void destroy() {
		logger = null;
	}

	public static String getParamsString(Map<String, String[]> params) {

		if (params == null || params.isEmpty())
			return "";

		StringBuilder builder = new StringBuilder();
		builder.append("?");
		

		for (String key : params.keySet()) {
			builder.append(key).append("=").append(params.get(key)[0])
					.append("&");

		}
		builder.deleteCharAt(builder.lastIndexOf("&"));

		return builder.toString();
	}

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			HttpSession session, String menthod, String url)
			throws IOException, ServletException {
		logger.info("Accept:{}",request.getHeader("Accept"));
		logger.info("Content-Type:{}",request.getHeader("Content-Type"));
		logger.info("------开始过滤--------");

		long before = System.currentTimeMillis();
		logger.info("拦截到请求:{} : {}{}", menthod,url,getParamsString(request.getParameterMap()));


		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		logger.info("请求结果:" + url + " status:" + response.getStatus());
		logger.info("花费时间：" + (after - before) + "ms");

		

		logger.info("------过滤结束---------\n");

	}

}