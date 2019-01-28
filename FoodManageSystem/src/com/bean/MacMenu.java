package com.bean;

public class MacMenu {

	//맥도날드 메뉴 번호
	private int mac_seq;
	private int mac_id;
	// 대표메뉴 인지 아닌지
	private int mac_rep;
	private String mac_name;
	private int mac_price;
	
	public int getMac_seq() {
		return mac_seq;
	}
	public void setMac_seq(int mac_seq) {
		this.mac_seq = mac_seq;
	}
	public int getMac_id() {
		return mac_id;
	}
	public void setMac_id(int mac_id) {
		this.mac_id = mac_id;
	}
	
	public int getMac_rep() {
		return mac_rep;
	}
	public void setMac_rep(int mac_rep) {
		this.mac_rep = mac_rep;
	}
	public String getMac_name() {
		return mac_name;
	}
	public void setMac_name(String mac_name) {
		this.mac_name = mac_name;
	}
	public int getMac_price() {
		return mac_price;
	}
	public void setMac_price(int mac_price) {
		this.mac_price = mac_price;
	}
	
	@Override
	public String toString() {
		return "MacMenu [mac_seq=" + mac_seq + ", mac_id=" + mac_id + ", mac_rep=" + mac_rep + ", mac_name=" + mac_name
				+ ", mac_price=" + mac_price + "]";
	}
	
	
	
}
