package com.bean;

public class JokbalMenu {
	private int jokbal_seq;
	private int jokbal_id;
	private int jokbal_rep;
	private String jokbal_name;
	private int jokbal_price;
	
	public int getJokbal_seq() {
		return jokbal_seq;
	}
	public void setJokbal_seq(int jokbal_seq) {
		this.jokbal_seq = jokbal_seq;
	}
	public int getJokbal_id() {
		return jokbal_id;
	}
	public void setJokbal_id(int jokbal_id) {
		this.jokbal_id = jokbal_id;
	}
	public int getJokbal_rep() {
		return jokbal_rep;
	}
	public void setJokbal_rep(int jokbal_rep) {
		this.jokbal_rep = jokbal_rep;
	}
	public String getJokbal_name() {
		return jokbal_name;
	}
	public void setJokbal_name(String jokbal_name) {
		this.jokbal_name = jokbal_name;
	}
	public int getJokbal_price() {
		return jokbal_price;
	}
	public void setJokbal_price(int jokbal_price) {
		this.jokbal_price = jokbal_price;
	}
	
	@Override
	public String toString() {
		return "JokbalMenu [jokbal_seq=" + jokbal_seq + ", jokbal_id=" + jokbal_id + ", jokbal_rep=" + jokbal_rep
				+ ", jokbal_name=" + jokbal_name + ", jokbal_price=" + jokbal_price + "]";
	}
	
	
	
}
