package com.bean;

public class ChiclegMenu {
	private int chicleg_seq;
	private int chicleg_id;
	private int chicleg_rep;
	private String chicleg_name;
	private int chicleg_price;
	
	public int getChicleg_seq() {
		return chicleg_seq;
	}
	public void setChicleg_seq(int chicleg_seq) {
		this.chicleg_seq = chicleg_seq;
	}
	public int getChicleg_id() {
		return chicleg_id;
	}
	public void setChicleg_id(int chicleg_id) {
		this.chicleg_id = chicleg_id;
	}
	public int getChicleg_rep() {
		return chicleg_rep;
	}
	public void setChicleg_rep(int chicleg_rep) {
		this.chicleg_rep = chicleg_rep;
	}
	public String getChicleg_name() {
		return chicleg_name;
	}
	public void setChicleg_name(String chicleg_name) {
		this.chicleg_name = chicleg_name;
	}
	public int getChicleg_price() {
		return chicleg_price;
	}
	public void setChicleg_price(int chicleg_price) {
		this.chicleg_price = chicleg_price;
	}
	
	@Override
	public String toString() {
		return "ChiclegMenu [chicleg_seq=" + chicleg_seq + ", chicleg_id=" + chicleg_id + ", chicleg_rep=" + chicleg_rep
				+ ", chicleg_name=" + chicleg_name + ", chicleg_price=" + chicleg_price + "]";
	}
	
	
	
}
