package com.weixin.entity;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

/**
 * @author jay
 * @since 2016年6月7日
 */
//@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -8884044676827065008L;

	//@Id
	private Integer id;

	//@Column
	private String name;

	//@Column
	private String email;

	//@Column
	private String password;

	//@Column
	private Date dob;

	public User() {
	}

	public User(Integer id, String name, String email, String password, Date dob) {
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
