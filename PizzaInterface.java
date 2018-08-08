package com.PizzaHut.Implementation;

import java.util.List;

import com.PizzaHut.Bean.PizzaBean;

public interface PizzaInterface {
void addProduct();
List<PizzaBean> viewPizzaDetails();
void updatePizzaRecord(int pId);
void deletePizzaRecord(int pId);
void back();
void billGenerate();
}
