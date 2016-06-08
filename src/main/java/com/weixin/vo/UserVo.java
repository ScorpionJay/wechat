package com.weixin.vo;

import java.io.Serializable;

/**
 * @author jay
 * @since 2016年6月7日
 */
public class UserVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String userName;

	private String password;

	private String email;

	public UserVo() {
	}

	public UserVo(String id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}

}
