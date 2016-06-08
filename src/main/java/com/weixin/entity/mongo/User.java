package com.weixin.entity.mongo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jay
 * @since 2016年6月8日
 */
@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@org.springframework.data.annotation.Id
	private String id;

	private String userName;

	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User() {
		super();
	}

	public User(String id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
