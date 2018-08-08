package com.PizzaHut.Implementation;

import java.util.List;

import com.PizzaHut.Bean.SoftDrinkBean;

public interface SoftDrinkInterface {
	void addSoftDrink();
	List<SoftDrinkBean> viewSoftDrinkDetails();
	void updateSoftDrinkRecord(int sId);
	void deleteSoftDrinkRecord(int sId);
	void back();
	void billGenerate();
}
