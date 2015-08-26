package com.github.ichenkaihua.secure.filter;

import com.github.ichenkaihua.Contants;
import com.github.ichenkaihua.jopo.UserPrincipal;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.secure.realm.StatelessToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoSesstionHttpMethodPermissionFilter extends
		HttpMethodPermissionFilter {

	private static Logger logger = LoggerFactory
			.getLogger(NoSesstionHttpMethodPermissionFilter.class);

	/**
	 * 当访问被拒绝时，调用这个方法，这里返回401页面
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return false;
	}

	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {

		HttpServletRequest req = (HttpServletRequest) request;

		String name = req.getHeader("name");
		String pass = req.getHeader("pass");

		StatelessToken token = new StatelessToken();

		// 如果是带验证的，则进行验证，否则没有验证，只能进行一般的请求
		if (name != null && pass != null) {
			token.setPrincipal(new UserPrincipal(name, UserPrincipal.PrincipType.USER));
			token.setPassword(pass);
			try {
				getSubject(request, response).login(token);
				// 如果认证成功，则增加request的属性，用于@CurrentUser注解使用
				User user = token.getUser();
				request.setAttribute(Contants.CURRENT_USER, user);

			} catch (AuthenticationException e) {
				logger.info("认证失败! "+e.getClass().getSimpleName());
			} catch (Exception e) {
				logger.info("其他认证失败! "+e.getClass().getSimpleName());
				e.printStackTrace();
			}

		}
		boolean result = super.isAccessAllowed(request, response, mappedValue);
		logger.info("restult:"+result);

		return super.isAccessAllowed(request, response, mappedValue);
	}

}
