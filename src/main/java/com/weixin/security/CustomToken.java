package com.weixin.security;

/**
 * @author jay
 * @since 2016年6月14日
 */
public class CustomToken
		extends org.springframework.security.authentication.UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;

	/**
	 * 自定义字段 token
	 */
	private String token;

	public CustomToken(Object principal, Object credentials, String token) {
		super(principal, credentials);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
}
