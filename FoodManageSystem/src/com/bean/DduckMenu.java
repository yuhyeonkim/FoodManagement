package com.bean;

public class DduckMenu {
	private int dduck_seq;
	private int dduck_id;
	private int dduck_rep;
	private String dduck_name;
	private int dduck_price;
	
	public int getDduck_seq() {
		return dduck_seq;
	}
	public void setDduck_seq(int dduck_seq) {
		this.dduck_seq = dduck_seq;
	}
	public int getDduck_id() {
		return dduck_id;
	}
	public void setDduck_id(int dduck_id) {
		this.dduck_id = dduck_id;
	}
	public int getDduck_rep() {
		return dduck_rep;
	}
	public void setDduck_rep(int dduck_rep) {
		this.dduck_rep = dduck_rep;
	}
	public String getDduck_name() {
		return dduck_name;
	}
	public void setDduck_name(String dduck_name) {
		this.dduck_name = dduck_name;
	}
	public int getDduck_price() {
		return dduck_price;
	}
	public void setDduck_price(int dduck_price) {
		this.dduck_price = dduck_price;
	}
	@Override
	public String toString() {
		return "DduckMenu [dduck_seq=" + dduck_seq + ", dduck_id=" + dduck_id + ", dduck_rep=" + dduck_rep
				+ ", dduck_name=" + dduck_name + ", dduck_price=" + dduck_price + "]";
	}
	
	
	
	
}
