package com.github.ichenkaihua.jopo;

/**
 * 
 * @ClassName UserPrincipal
 * @Description
 * @Author chenkaihua
 * @Email admin@chenkaihua.com
 * @Date 2015年5月8日 下午3:30:25
 *
 */
public class UserPrincipal {
	
	
	

	private String username;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param username
	 * @param principType
	 */
	public UserPrincipal(String username, PrincipType principType) {
		super();
		this.username = username;
		this.principType = principType;
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * 构造一个类型为guest的身份
	 * <p>
	 * Description:
	 * </p>
	 */
	public UserPrincipal() {
		this("", PrincipType.USER);
	}

	private PrincipType principType;

	public enum PrincipType {
		USER("user"), ADMIN("admin");
		private String roleName;

		private PrincipType(String roleName) {
			this.roleName = roleName;
		}

		/**
		 * 
		 * @Title: getRoleName
		 * @Description 我们都是
		 * @Param
		 * @Return String
		 * @Throws
		 */
		public String getRoleName() {
			return roleName;
		}

	}

	/**
	 * @return 获取 username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return 获取 principType
	 */
	public PrincipType getPrincipType() {
		return principType;
	}

	/**
	 * @param principType
	 *            要设置的 principType
	 */
	public void setPrincipType(PrincipType principType) {
		this.principType = principType;
	}

}
