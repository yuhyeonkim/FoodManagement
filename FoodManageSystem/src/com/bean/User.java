package com.bean;

public class User {
	private int user_seq;
	private int user_sex;
	private String user_name;
	private String user_id;
	private String user_pw;
	private String user_phone;
	private String user_loc;
	private int user_manage;
	
	public int getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}
	public int getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_loc() {
		return user_loc;
	}
	public void setUser_loc(String user_loc) {
		this.user_loc = user_loc;
	}
	public int getUser_manage() {
		return user_manage;
	}
	public void setUser_manage(int user_manage) {
		this.user_manage = user_manage;
	}
	
	@Override
	public String toString() {
		return "User [user_seq=" + user_seq + ", user_sex=" + user_sex + ", user_name=" + user_name + ", user_id="
				+ user_id + ", user_pw=" + user_pw + ", user_phone=" + user_phone + ", user_loc=" + user_loc
				+ ", user_manage=" + user_manage + "]";
	}
	
	
	
	
}
