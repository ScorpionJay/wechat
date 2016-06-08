package com.weixin.entity.mongo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 微信信息
 * @author jay
 * @since 2016年6月8日
 */
@Document
public class Wechat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	/**
	 * 第三方用户唯一凭证
	 */
	private String appId;

	/**
	 * 第三方用户唯一凭证密钥
	 */
	private String appSecret;

	/**
	 * 获取到的凭证
	 */
	private String token;

	/**
	 * jsapi ticket
	 */
	private String jsapiTicket;

	/**
	 * 获取token的时间
	 */
	private Date tokenDate;

	/**
	 * 获取jsapi ticket时间
	 */
	private Date jsapiTicketDate;

	public Wechat() {
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

}
