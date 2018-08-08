package com.PizzaHut.Customer;

import java.util.List;

import com.PizzaHut.Bean.IceCreamBean;
import com.PizzaHut.Bean.PizzaBean;
import com.PizzaHut.Bean.SoftDrinkBean;

public interface CustomerMenuInterface {
List<PizzaBean> viewPizzas();
void selectedPizzas();
List<IceCreamBean> viewIceCreams();
void selectedIceCream();
List<SoftDrinkBean> viewSoftDrinks();
void SelectedSoftDrink();
}
