package com.weixin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信信息
 * @author jay
 * @since 2016年6月8日
 */
public class WechatVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	/**
	 * 第三方用户唯一凭证
	 */
	private String appId = "";

	/**
	 * 第三方用户唯一凭证密钥
	 */
	private String appSecret = "";

	/**
	 * 获取到的凭证
	 */
	private String token = "";

	/**
	 * jsapi ticket
	 */
	private String jsapiTicket = "";

	/**
	 * 获取token的时间
	 */
	private Date tokenDate = new Date();

	/**
	 * 获取jsapi ticket时间
	 */
	private Date jsapiTicketDate = new Date();

	/**
	 * 标题 用户区分公众号名称
	 */
	private String title;
	
	
	public WechatVo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getJsapiTicket() {
		return jsapiTicket;
	}

	public void setJsapiTicket(String jsapiTicket) {
		this.jsapiTicket = jsapiTicket;
	}

	public Date getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(Date tokenDate) {
		this.tokenDate = tokenDate;
	}

	public Date getJsapiTicketDate() {
		return jsapiTicketDate;
	}

	public void setJsapiTicketDate(Date jsapiTicketDate) {
		this.jsapiTicketDate = jsapiTicketDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "WechatVo [id=" + id + ", appId=" + appId + ", appSecret=" + appSecret + ", token=" + token
				+ ", jsapiTicket=" + jsapiTicket + ", tokenDate=" + tokenDate + ", jsapiTicketDate=" + jsapiTicketDate
				+ ", title=" + title + "]";
	}

	
	
}
