package com.bean;

public class BbqMenu {
	private int bbq_seq;
	private int bbq_id;
	private int bbq_rep;
	private String bbq_name;
	private int bbq_price;
	public int getBbq_seq() {
		return bbq_seq;
	}
	public void setBbq_seq(int bbq_seq) {
		this.bbq_seq = bbq_seq;
	}
	public int getBbq_id() {
		return bbq_id;
	}
	public void setBbq_id(int bbq_id) {
		this.bbq_id = bbq_id;
	}
	public int getBbq_rep() {
		return bbq_rep;
	}
	public void setBbq_rep(int bbq_rep) {
		this.bbq_rep = bbq_rep;
	}
	public String getBbq_name() {
		return bbq_name;
	}
	public void setBbq_name(String bbq_name) {
		this.bbq_name = bbq_name;
	}
	public int getBbq_price() {
		return bbq_price;
	}
	public void setBbq_price(int bbq_price) {
		this.bbq_price = bbq_price;
	}
	
	@Override
	public String toString() {
		return "BbqMenu [bbq_seq=" + bbq_seq + ", bbq_id=" + bbq_id + ", bbq_rep=" + bbq_rep + ", bbq_name=" + bbq_name
				+ ", bbq_price=" + bbq_price + "]";
	}
	
	
	
}
