package com.PizzaHut.Implementation;

import java.util.List;

import com.PizzaHut.Bean.IceCreamBean;

public interface IceCreamInterface {
	void addIceCreamProduct();
	List<IceCreamBean> viewIceCreamDetails();
	void updateIceCreamRecord(int iceId);
	void deleteIceCreamRecord(int iceId);
	void back();
	void billGenerate();
}
