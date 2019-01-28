package com.bean;

public class GopMenu {
	private int gop_seq;
	private int gop_id;
	private int gop_rep;
	private String gop_name;
	private int gop_price;
	
	public int getGop_seq() {
		return gop_seq;
	}
	public void setGop_seq(int gop_seq) {
		this.gop_seq = gop_seq;
	}
	public int getGop_id() {
		return gop_id;
	}
	public void setGop_id(int gop_id) {
		this.gop_id = gop_id;
	}
	public int getGop_rep() {
		return gop_rep;
	}
	public void setGop_rep(int gop_rep) {
		this.gop_rep = gop_rep;
	}
	public String getGop_name() {
		return gop_name;
	}
	public void setGop_name(String gop_name) {
		this.gop_name = gop_name;
	}
	public int getGop_price() {
		return gop_price;
	}
	public void setGop_price(int gop_price) {
		this.gop_price = gop_price;
	}
	
	@Override
	public String toString() {
		return "GopMenu [gop_seq=" + gop_seq + ", gop_id=" + gop_id + ", gop_rep=" + gop_rep + ", gop_name=" + gop_name
				+ ", gop_price=" + gop_price + "]";
	}
	
	
	
}
