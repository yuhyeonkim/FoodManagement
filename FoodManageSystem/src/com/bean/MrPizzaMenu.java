package com.bean;

public class MrPizzaMenu {
	
	private int mrpizza_seq;
	private int mrpizza_id;
	private int mrpizza_rep;
	private String mrpizza_name;
	private int mrpizza_price;
	
	public int getMrpizza_seq() {
		return mrpizza_seq;
	}
	public void setMrpizza_seq(int mrpizza_seq) {
		this.mrpizza_seq = mrpizza_seq;
	}
	public int getMrpizza_id() {
		return mrpizza_id;
	}
	public void setMrpizza_id(int mrpizza_id) {
		this.mrpizza_id = mrpizza_id;
	}
	public int getMrpizza_rep() {
		return mrpizza_rep;
	}
	public void setMrpizza_rep(int mrpizza_rep) {
		this.mrpizza_rep = mrpizza_rep;
	}
	public String getMrpizza_name() {
		return mrpizza_name;
	}
	public void setMrpizza_name(String mrpizza_name) {
		this.mrpizza_name = mrpizza_name;
	}
	public int getMrpizza_price() {
		return mrpizza_price;
	}
	public void setMrpizza_price(int mrpizza_price) {
		this.mrpizza_price = mrpizza_price;
	}
	
	@Override
	public String toString() {
		return "MrPizzaMenu [mrpizza_seq=" + mrpizza_seq + ", mrpizza_id=" + mrpizza_id + ", mrpizza_rep=" + mrpizza_rep
				+ ", mrpizza_name=" + mrpizza_name + ", mrpizza_price=" + mrpizza_price + "]";
	}
	
	
}
