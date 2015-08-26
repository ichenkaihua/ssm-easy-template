package com.github.ichenkaihua.controller;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import javax.servlet.http.HttpServletResponse;

import com.github.ichenkaihua.exception.HttpStatusCodeException;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.ichenkaihua.constance.HttpStatus;

@ControllerAdvice()
public class ExceptionController {
	private Logger logger = Logger.getLogger(ExceptionController.class);

	static {
		trustSelfSignedSSL();
	}

	/**
	 * 捕获{@link HttpStatusCodeException}异常，最终将
	 * {@link HttpStatusCodeException#getStatusCode()}获取的状态码写入到
	 * {@link HttpServletResponse}返回给客户端
	 * 
	 * @param response
	 * @param e
	 */
	@ExceptionHandler(value = HttpStatusCodeException.class)
	public void handerStatesException(HttpServletResponse response,
			HttpStatusCodeException e) {
		System.out.println("");
		logger.info("捕捉到一个:" + e.getClass().getName() + "异常");

		response.setStatus(e.getStatusCode());
	}

	/**
	 * 权限错误时调用此方法
	 * 
	 * @Title handlerAuthriztion
	 * @Description
	 * @Param
	 * @Return void
	 * @Throws
	 */
	@ExceptionHandler(value = AuthorizationException.class)
	public void handlerAuthriztionException(HttpServletResponse response) {
		logger.info("捕捉到一个:" + AuthorizationException.class.getSimpleName() + "异常");
		response.setStatus(HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = org.springframework.web.client.HttpStatusCodeException.class)
	public void handlerRestException(HttpServletResponse response,
			org.springframework.web.client.HttpStatusCodeException exception) {
		int code = exception.getStatusCode().value();
		logger.info("捕获到一个:"
				+ org.springframework.web.client.HttpStatusCodeException.class
						.getSimpleName() + "异常!" + exception.getStatusCode());

		if (code == 404) {
			response.setStatus(HttpStatus.NO_RESOURCE);
		} else if (code == 401)
			response.setStatus(HttpStatus.FAIL_1);
		else
			response.setStatus(code);

	}

	private static void trustSelfSignedSSL() {
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager() {
				@SuppressWarnings("unused")
				public void checkClientTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {
				}

				@SuppressWarnings("unused")
				public void checkServerTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {
				}

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(
						java.security.cert.X509Certificate[] arg0, String arg1)
						throws java.security.cert.CertificateException {
				}

				@Override
				public void checkServerTrusted(
						java.security.cert.X509Certificate[] arg0, String arg1)
						throws java.security.cert.CertificateException {

				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLContext.setDefault(ctx);
		} catch (Exception ex) {
			throw new RuntimeException("Exception occurred ", ex);
		}
	}

}
