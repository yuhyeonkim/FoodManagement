package com.bean;

public class ChinaFoodMenu {
	private int chinafood_seq;
	private int chinafood_id;
	private int chinafood_rep;
	private String chinafood_name;
	private int chinafood_price;
	
	public int getChinafood_seq() {
		return chinafood_seq;
	}
	public void setChinafood_seq(int chinafood_seq) {
		this.chinafood_seq = chinafood_seq;
	}
	public int getChinafood_id() {
		return chinafood_id;
	}
	public void setChinafood_id(int chinafood_id) {
		this.chinafood_id = chinafood_id;
	}
	public int getChinafood_rep() {
		return chinafood_rep;
	}
	public void setChinafood_rep(int chinafood_rep) {
		this.chinafood_rep = chinafood_rep;
	}
	public String getChinafood_name() {
		return chinafood_name;
	}
	public void setChinafood_name(String chinafood_name) {
		this.chinafood_name = chinafood_name;
	}
	public int getChinafood_price() {
		return chinafood_price;
	}
	public void setChinafood_price(int chinafood_price) {
		this.chinafood_price = chinafood_price;
	}
	
	@Override
	public String toString() {
		return "ChinaFoodMenu [chinafood_seq=" + chinafood_seq + ", chinafood_id=" + chinafood_id + ", chinafood_rep="
				+ chinafood_rep + ", chinafood_name=" + chinafood_name + ", chinafood_price=" + chinafood_price + "]";
	}
	
	
}
