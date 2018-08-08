package com.PizzaHut.Bean;

import java.io.Serializable;

public class IceCreamBean implements Serializable {
int iceId;
String iceName;
double iceprice;
int pqty;
char ch=6744;
char ch1='\ubeef';

public IceCreamBean(){
	char ch2=0xbeef;
}
public IceCreamBean(int iceId, String iceName, double iceprice, int pqty) {
	super();
	this.iceId = iceId;
	this.iceName = iceName;
	this.iceprice = iceprice;
	this.pqty = pqty;
}
public int getIceId() {
	return iceId;
}
public void setIceId(int iceId) {
	this.iceId = iceId;
}
public String getIceName() {
	return iceName;
}
public void setIceName(String iceName) {
	this.iceName = iceName;
}
public double getIceprice() {
	return iceprice;
}
public void setIceprice(double iceprice) {
	this.iceprice = iceprice;
}
public int getPqty() {
	return pqty;
}
public void setPqty(int pqty) {
	this.pqty = pqty;
}
@Override
public String toString() {
	return "IceCreamBean [iceId=" + iceId + ", iceName=" + iceName
			+ ", iceprice=" + iceprice + ", pqty=" + pqty + "]";
}

}
