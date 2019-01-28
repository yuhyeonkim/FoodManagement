package com.bean;

public class MomsMenu {
	private int moms_seq;
	private int moms_id;
	private int moms_rep;
	private String moms_name;
	private int moms_price;
	public int getMoms_seq() {
		return moms_seq;
	}
	public void setMoms_seq(int moms_seq) {
		this.moms_seq = moms_seq;
	}
	public int getMoms_id() {
		return moms_id;
	}
	public void setMoms_id(int moms_id) {
		this.moms_id = moms_id;
	}
	public int getMoms_rep() {
		return moms_rep;
	}
	public void setMoms_rep(int moms_rep) {
		this.moms_rep = moms_rep;
	}
	public String getMoms_name() {
		return moms_name;
	}
	public void setMoms_name(String moms_name) {
		this.moms_name = moms_name;
	}
	public int getMoms_price() {
		return moms_price;
	}
	public void setMoms_price(int moms_price) {
		this.moms_price = moms_price;
	}
	@Override
	public String toString() {
		return "MomsMenu [moms_seq=" + moms_seq + ", moms_id=" + moms_id + ", moms_rep=" + moms_rep + ", moms_name="
				+ moms_name + ", moms_price=" + moms_price + "]";
	}
	
	
	
}
