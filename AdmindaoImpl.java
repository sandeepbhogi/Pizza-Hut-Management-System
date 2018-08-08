package com.PizzaHut.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.PizzaHut.Bean.IceCreamBean;
import com.PizzaHut.Bean.PizzaBean;
import com.PizzaHut.Bean.SoftDrinkBean;
import com.PizzaHut.Implementation.AdminStockImpl;

public class AdmindaoImpl implements AdminDao {
	AdminStockImpl asi = new AdminStockImpl();
	List<PizzaBean> pizzas1 = new ArrayList<PizzaBean>();
	List<IceCreamBean> icecream = new ArrayList<IceCreamBean>();
	List<SoftDrinkBean> drink = new ArrayList<SoftDrinkBean>();
	Scanner sc = new Scanner(System.in);

	void AdminMenu() {
System.out.println("-------------welcome to adminMenu--------------");
		System.out.println("1) Pizzas");
		System.out.println("2)IceCream");
		System.out.println("3)SoftDrink");
		System.out.println("4)back ");
		System.out.println("5)exit");
		System.out.println("Enter your choice");
		int n = sc.nextInt();
		switch (n) {

		case 1:
			pizza();
			AdminMenu();
			break;

		case 2:
			icecream();
			AdminMenu();
			break;
		case 3:
			softDrink();
			AdminMenu();
			break;
		case 4:
			back();
			break;
		case 5:
			exit();
			AdminMenu();
			break;
		default:
			System.out.println("choose between 1-5");
			break;
		}
	}

	@Override
	public void pizza() {
		// TODO Auto-generated method stub

		System.out.println("--------welcome to pizza section------");
		System.out.println("1)add pizza");
		System.out.println("2)view All Pizzas");
		System.out.println("3)Update Pizza Record");
		System.out.println("4)Delete pizza Record");
		System.out.println("5)Back(To Module)");
		System.out.println("6)Back(to Main Menu)");
		
		System.out.println("---------------------------------------------");
		System.out.println("Enter your choice");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			asi.addProduct();
			pizza();
			break;
		case 2:
			pizzas1 = asi.viewPizzaDetails();
			System.out.println("PID" + "\t" + "PNAME" + "\t" + "pPRICE");
			System.out.println("-----------------------------");
			for (PizzaBean p : pizzas1) {
				System.out.println(p);
			}
			pizza();
			break;
		case 3:
			System.out.println("Enter pId");

			asi.updatePizzaRecord(sc.nextInt());
			pizza();
			break;
		case 4:
			System.out.println("Enter pId");
			asi.deletePizzaRecord(sc.nextInt());
			pizza();
			break;
		case 5:
			backToModule();
			break;
		case 6:
			asi.back();
			break;
		case 7:
			asi.billGenerate();
			break;
		default:
			System.out.println("choose between 1-6");
		}
	}

	@Override
	public void icecream() {
		// TODO Auto-generated method stub
		System.out.println("--------welcome to Icecream section------");
		System.out.println("1)add IceCream");
		System.out.println("2)view All IceCreams");
		System.out.println("3)Update IceCream Record");
		System.out.println("4)Delete IceCream Record");
		System.out.println("5)Back(To module)");
		System.out.println("6)Back(To main menu)");
		
		System.out.println("---------------------------------------------");
		System.out.println("Enter your choice");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			asi.addIceCreamProduct();
			icecream();
			break;
		case 2:
			icecream = asi.viewIceCreamDetails();
			System.out.println("iceid" + "\t" + "iceNAME" + "\t" + "icePRICE");
			for (IceCreamBean i : icecream) {
				System.out.println(i);
			}
			icecream();
			break;
		case 3:
			System.out.println("Enter iceId");
			asi.updateIceCreamRecord(sc.nextInt());
			icecream();
			break;
		case 4:
			System.out.println("Enter iceId");
			asi.deleteIceCreamRecord(sc.nextInt());
			icecream();
			break;
		case 5:
			backToModule();
			break;
		case 6:
			asi.back();
			break;
		case 7:
			asi.billGenerate();
			break;
			default:
				System.out.println("choose Between 1-6");
		}

	}

	@Override
	public void softDrink() {
		// TODO Auto-generated method stub
		System.out.println("--------welcome to softDrink section------");
		System.out.println("1)add softDrink");
		System.out.println("2)view All softDrinks");
		System.out.println("3)Update softDrink Record");
		System.out.println("4)Delete softDrink Record");
		System.out.println("5)Back(To Module)");
		System.out.println("6)Back(To main Menu)");
		
		System.out.println("---------------------------------------------");
		System.out.println("Enter your choice");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			asi.addSoftDrink();
			softDrink();
			break;
		case 2:
			drink = asi.viewSoftDrinkDetails();
			System.out.println("sId" + "\t" + "sName" + "\t" + "sprice");
			for (SoftDrinkBean s : drink) {
				System.out.println(s);
			}
			softDrink();
			break;
		case 3:
			System.out.println("Enter sId");
			asi.updateSoftDrinkRecord(sc.nextInt());
			softDrink();
			break;
		case 4:
			System.out.println("Enter sId");
			asi.deleteSoftDrinkRecord(sc.nextInt());
			softDrink();
			break;
		case 5:
			backToModule();
			break;
		case 6:
			asi.back();
			break;
		case 7:
			asi.billGenerate();
			break;
			default:
				System.out.println("choose between 1-6");
		}

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		PizzaHut.main(null);
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		System.out.println("Thank You");
	}

	@Override
	public void backToModule() {
		// TODO Auto-generated method stub
		AdminMenu();
	}

}
