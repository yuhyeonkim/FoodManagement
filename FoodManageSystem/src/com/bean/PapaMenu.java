package com.bean;

public class PapaMenu {
	private int papa_seq;
	private int papa_id;
	private int papa_rep;
	private String papa_name;
	private int papa_price;
	
	public int getPapa_seq() {
		return papa_seq;
	}
	public void setPapa_seq(int papa_seq) {
		this.papa_seq = papa_seq;
	}
	public int getPapa_id() {
		return papa_id;
	}
	public void setPapa_id(int papa_id) {
		this.papa_id = papa_id;
	}
	public int getPapa_rep() {
		return papa_rep;
	}
	public void setPapa_rep(int papa_rep) {
		this.papa_rep = papa_rep;
	}
	public String getPapa_name() {
		return papa_name;
	}
	public void setPapa_name(String papa_name) {
		this.papa_name = papa_name;
	}
	public int getPapa_price() {
		return papa_price;
	}
	public void setPapa_price(int papa_price) {
		this.papa_price = papa_price;
	}
	
	@Override
	public String toString() {
		return "PapaMenu [papa_seq=" + papa_seq + ", papa_id=" + papa_id + ", papa_rep=" + papa_rep + ", papa_name="
				+ papa_name + ", papa_price=" + papa_price + "]";
	}
	

	
}
