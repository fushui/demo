package com.fushui.jdbc_demo.model;

import java.util.Date;

public class Goddess {
	private Integer id;
	private Integer sex;
	private Integer age;
	private Date birthday;

	private String user_name;
	private String email;
	private String mobile;
	private Date create_date;
	private Date update_date;
	private String create_user;
	private String update_user;
	private Integer isDel;

	
	
	@Override
	public String toString() {
		return "Goddess [id=" + id + ", sex=" + sex + ", age=" + age
				+ ", birthday=" + birthday + ", user_name=" + user_name
				+ ", email=" + email + ", mobile=" + mobile + ", create_date="
				+ create_date + ", update_date=" + update_date
				+ ", create_user=" + create_user + ", update_user="
				+ update_user + ", isDel=" + isDel + "]";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_use) {
		this.update_user = update_use;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
