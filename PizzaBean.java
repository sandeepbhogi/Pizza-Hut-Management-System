package com.PizzaHut.Bean;

import java.io.Serializable;

public class PizzaBean implements Serializable{
	int pId;
	String pName;
	int pPrice;
	int pqty;
	@Override
	public String toString() {
		return "PizzaBean [pId=" + pId + ", pName=" + pName + ", pPrice="
				+ pPrice + ", pqty=" + pqty + "]";
	}
	public PizzaBean(){
		
	}
	public PizzaBean(int pId, String pName, int pPrice, int pqty) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pqty = pqty;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	
}