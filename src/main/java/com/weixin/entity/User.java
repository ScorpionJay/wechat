package com.weixin.entity;

import java.io.Serializable;
import java.util.Date;

/**
*@author	jay
*@since		2016年6月7日
*/
public class User implements Serializable{

	private static final long serialVersionUID = -8884044676827065008L;

	private Integer id;
	private String name;
	private String email;
	private String password;
	private Date dob;
	
	public User() {
	}
	
	public User(Integer id, String name, String email, String password, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "SUser [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ "]";
	}

	
	
}
