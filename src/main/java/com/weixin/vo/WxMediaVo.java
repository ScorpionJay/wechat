package com.weixin.vo;

import java.io.Serializable;

/**
 * {"type":"image","media_id":"T7Nk3B95drKWVXL5HaLV06Ka93vUYZfoxsGlECIO7wM632K8-W5N2zJYxTGBxgAk","created_at":1465718909}
* @author	jay
* @since	2016年6月12日
*/
public class WxMediaVo implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String type;
	
	private String media_id;
	
	private Long created_at;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public Long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}

	public WxMediaVo() {
		super();
	}

	@Override
	public String toString() {
		return "WxMediaVo [type=" + type + ", media_id=" + media_id + ", create_at=" + created_at + "]";
	}
	
	

}
