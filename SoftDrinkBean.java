package com.PizzaHut.Bean;

import java.io.Serializable;

public class SoftDrinkBean implements Serializable {
int sId;
String sName;
double sPrice;
int sqty;
public SoftDrinkBean(){
	
}
public SoftDrinkBean(int sId, String sName, double sPrice, int sqty) {
	super();
	this.sId = sId;
	this.sName = sName;
	this.sPrice = sPrice;
	this.sqty = sqty;
}
public int getsId() {
	return sId;
}
public void setsId(int sId) {
	this.sId = sId;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public double getsPrice() {
	return sPrice;
}
public void setsPrice(double sPrice) {
	this.sPrice = sPrice;
}
public int getSqty() {
	return sqty;
}
public void setSqty(int sqty) {
	this.sqty = sqty;
}
@Override
public String toString() {
	return "SoftDrinkBean [sId=" + sId + ", sName=" + sName + ", sPrice="
			+ sPrice + ", sqty=" + sqty + "]";
}

}
