package com.weixin.vo;

/**
 * @author       Jay
 */
public class AccessToken {
	
	private String accessToken;		//获取到的凭证
	private int expiresIn;			//凭证有效时间，单位：秒
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "票据：" + accessToken + "\n有效时间： " + expiresIn;
	}
}
