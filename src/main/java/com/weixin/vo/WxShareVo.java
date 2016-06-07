package com.weixin.vo;

import java.io.Serializable;
import java.util.Map;


public class WxShareVo implements Serializable{

	private static final long serialVersionUID = 1356549545920070207L;
	
	private String appId;
	private String title;
	private String link;
	private String desc;
	private String imgUrl;
	
	private Map<String, String> map;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public WxShareVo() {
		super();
	}
	public WxShareVo(String appId, String title, String link, String desc, String imgUrl) {
		super();
		this.appId = appId;
		this.title = title;
		this.link = link;
		this.desc = desc;
		this.imgUrl = imgUrl;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	
	


}
