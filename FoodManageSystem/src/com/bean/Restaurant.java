package com.bean;

public class Restaurant {
	private int rest_seq;
	private String rest_name;
	private String rest_loc;
	private int rest_rate;
	
	public int getRest_seq() {
		return rest_seq;
	}
	public void setRest_seq(int rest_seq) {
		this.rest_seq = rest_seq;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public String getRest_loc() {
		return rest_loc;
	}
	public void setRest_loc(String rest_loc) {
		this.rest_loc = rest_loc;
	}
	public int getRest_rate() {
		return rest_rate;
	}
	public void setRest_rate(int rest_rate) {
		this.rest_rate = rest_rate;
	}
	
	@Override
	public String toString() {
		return "Restaurant [rest_seq=" + rest_seq + ", rest_name=" + rest_name + ", rest_loc=" + rest_loc
				+ ", rest_rate=" + rest_rate + "]";
	}
	
	
	
}
