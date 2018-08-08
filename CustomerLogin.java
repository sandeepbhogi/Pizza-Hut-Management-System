package com.PizzaHut.Customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.PizzaHut.Bean.IceCreamBean;
import com.PizzaHut.Bean.PizzaBean;
import com.PizzaHut.Bean.SoftDrinkBean;
import com.PizzaHut.Dao.PizzaHut;

public class CustomerLogin implements CustomerInterface, CustomerMenuInterface {
	List<PizzaBean> pizza = new ArrayList<PizzaBean>();
	List<PizzaBean> pizzas = null;
	List<PizzaBean> tempList = null;
	List<IceCreamBean> icecreams = null;
	List<IceCreamBean> icecream = new ArrayList<IceCreamBean>();
	List<IceCreamBean> tempList1 = null;
	List<SoftDrinkBean> drink = null;
	List<SoftDrinkBean> drinks = new ArrayList<SoftDrinkBean>();
	List<SoftDrinkBean> tempList2 = null;
	double bill;
	Scanner sc = new Scanner(System.in);
	PizzaBean pi = null;
	IceCreamBean icb = null;
	SoftDrinkBean sd = null;
	File original = new File("pizza.txt");
	File tempFile = new File("temp.txt");
	File original1 = new File("iceCream.txt");
	File original2 = new File("softDrink.txt");
	File tempFile1 = new File("temp1.txt");
	File tempFile2 = new File("temp2.txt");
	FileInputStream fis = null;
	FileOutputStream fos = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	public void customerMenu() {
		System.out.println("---------welcome to PIZZAHUT--------------");
		System.out.println("1)view Pizzas");
		System.out.println("2)Select Pizza");
		System.out.println("3)view icecreams");
		System.out.println("4)select icecream");
		System.out.println("5)view SoftDrink");
		System.out.println("6)select SoftDrink");
		System.out.println("7)back");
		System.out.println("8)Exit");
		System.out.println("Enter your choice");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			pizza = viewPizzas();
			System.out.println("PID" + "\t" + "PNAME" + "\t" + "pPRICE"
					+ "pqty");
			System.out.println("-----------------------------");
			for (PizzaBean p : pizza) {
				System.out.println(p);
			}
			customerMenu();
			break;
		case 2:
			selectedPizzas();
			customerMenu();
			break;
		case 3:
			icecream = viewIceCreams();
			System.out.println("iceID" + "\t" + "iceNAME" + "\t" + "icePRICE"
					+ "iceqty");
			System.out.println("-----------------------------");
			for (IceCreamBean p : icecream) {
				System.out.println(p);
			}
			customerMenu();
			break;
		case 4:
			selectedIceCream();
			customerMenu();
			break;
		case 5:
			drinks = viewSoftDrinks();
			System.out.println("sID" + "\t" + "sNAME" + "\t" + "sPRICE"
					+ "sqty");
			System.out.println("-----------------------------");
			for (SoftDrinkBean p : drinks) {
				System.out.println(p);
			}
			customerMenu();
		case 6:
			SelectedSoftDrink();
			customerMenu();
		case 7:
			back();
			break;
		case 8:
			exit();
			break;
		default:
			System.out.println("choose between 1-8");
		}
	}

	@Override
	public void pizzaMenu() {
		// TODO Auto-generated method stub

		List<String> pizza = new ArrayList<String>();
		List<Integer> pizzacost = new ArrayList<Integer>();
		System.out.println("---------pizza Menu--------------");
		System.out.println("1)paneer pizza     =" + "Rs.100");
		System.out.println("2)Tomato pizza     =" + "Rs.69");
		System.out.println("3)Mushroom pizza     =" + "Rs.79");
		System.out.println("4)Chicken pizza     =" + "Rs.149");
		System.out.println("5)DoubleCheese pizza     =" + "Rs.179");
		System.out.println("Enter Your choice");
		pizza.add("paneer pizza");
		pizza.add("Tomato pizza ");
		pizza.add("Mushroom pizza ");
		pizza.add("Chicken pizza ");
		pizza.add("DoubleCheese pizza");
		pizzacost.add(100);
		pizzacost.add(69);
		pizzacost.add(79);
		pizzacost.add(149);
		pizzacost.add(179);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println(pizza.get(n - 1) + "   =    "
					+ pizzacost.get(n - 1));
			System.out.println("how much Quantity u want");
			int a = sc.nextInt();
			bill = pizzacost.get(n - 1) * a;
			System.out.println(pizzacost.get(n - 1) * a);
			PizzaBean bean = null;
			try {
				fis = new FileInputStream("pizza.txt");
				ois = new ObjectInputStream(fis);
				pizzas = (List<PizzaBean>) ois.readObject();
				for (PizzaBean p : pizzas) {
					// System.out.println(p.getPqty()-a4);

					p.setPqty(p.getPqty() - a);
					bean = p;
					pizzas.add(bean);
				}

				// AdminStockImpl dao=new AdminStockImpl();
				fos = new FileOutputStream("pizza.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(pizzas);
				oos.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 2:
			System.out.println(pizza.get(n - 1) + "   =    "
					+ pizzacost.get(n - 1));
			System.out.println("how much Quantity u want");
			int a1 = sc.nextInt();
			bill = pizzacost.get(n - 1) * a1;
			System.out.println(pizzacost.get(n - 1) * a1);
			PizzaBean bean1 = null;
			try {
				fis = new FileInputStream("pizza.txt");
				ois = new ObjectInputStream(fis);
				pizzas = (List<PizzaBean>) ois.readObject();
				for (PizzaBean p : pizzas) {
					// System.out.println(p.getPqty()-a1);

					p.setPqty(p.getPqty() - a1);
					bean1 = p;
					pizzas.add(bean1);
				}

				// AdminStockImpl dao=new AdminStockImpl();
				fos = new FileOutputStream("pizza.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(pizzas);
				oos.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println(pizza.get(n - 1) + "   =    "
					+ pizzacost.get(n - 1));
			System.out.println("how much Quantity u want");
			int a2 = sc.nextInt();
			bill = pizzacost.get(n - 1) * a2;
			System.out.println(pizzacost.get(n - 1) * a2);
			PizzaBean bean2 = null;
			try {
				fis = new FileInputStream("pizza.txt");
				ois = new ObjectInputStream(fis);
				pizzas = (List<PizzaBean>) ois.readObject();
				for (PizzaBean p : pizzas) {
					// System.out.println(p.getPqty()-a4);

					p.setPqty(p.getPqty() - a2);
					bean2 = p;
					pizzas.add(bean2);
				}

				// AdminStockImpl dao=new AdminStockImpl();
				fos = new FileOutputStream("pizza.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(pizzas);
				oos.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println(pizza.get(n - 1) + "   =    "
					+ pizzacost.get(n - 1));
			System.out.println("how much Quantity u want");
			int a3 = sc.nextInt();
			bill = pizzacost.get(n - 1) * a3;
			System.out.println(pizzacost.get(n - 1) * a3);
			PizzaBean bean3 = null;
			try {
				fis = new FileInputStream("pizza.txt");
				ois = new ObjectInputStream(fis);
				pizzas = (List<PizzaBean>) ois.readObject();
				for (PizzaBean p : pizzas) {
					// System.out.println(p.getPqty()-a3);

					p.setPqty(p.getPqty() - a3);
					bean3 = p;
					pizzas.add(bean3);
				}

				// AdminStockImpl dao=new AdminStockImpl();
				fos = new FileOutputStream("pizza.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(pizzas);
				oos.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println(pizza.get(n - 1) + "   =    "
					+ pizzacost.get(n - 1));
			System.out.println("how much Quantity u want");
			int a4 = sc.nextInt();
			bill = pizzacost.get(n - 1) * a4;
			System.out.println(pizzacost.get(n - 1) * a4);
			PizzaBean bean4 = null;

			try {
				fis = new FileInputStream("pizza.txt");
				ois = new ObjectInputStream(fis);
				pizzas = (List<PizzaBean>) ois.readObject();
				for (PizzaBean p : pizzas) {
					// System.out.println(p.getPqty()-a4);

					p.setPqty(p.getPqty() - a4);
					bean4 = p;
					pizzas.add(bean4);
				}

				// AdminStockImpl dao=new AdminStockImpl();
				fos = new FileOutputStream("pizza.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(pizzas);
				oos.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Choose between 1-5");
		}

	}

	@Override
	public void iceCreamMenu() {
		// TODO Auto-generated method stub
		List<String> ice = new ArrayList<String>();
		List<Integer> icecost = new ArrayList<Integer>();
		System.out.println("---------pizza Menu--------------");
		System.out.println("1)Butter Scotch     =" + "Rs.100");
		System.out.println("2)Coconut Flavour    =" + "Rs.69");
		System.out.println("3)Black Forest     =" + "Rs.79");
		System.out.println("4)Magnum    =" + "Rs.149");
		System.out.println("5)Oreo Flavour     =" + "Rs.179");
		System.out.println("Enter Your choice");
		ice.add("Butter Scotch");
		ice.add("Coconut Flavour ");
		ice.add("Black Forest");
		ice.add("Magnum");
		ice.add("Oreo Flavour");
		icecost.add(55);
		icecost.add(45);
		icecost.add(89);
		icecost.add(99);
		icecost.add(79);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out
					.println(ice.get(n - 1) + "   =    " + icecost.get(n - 1));
			System.out.println("how much Quantity u want");
			int b = sc.nextInt();
			bill = icecost.get(n - 1) * b;
			System.out.println(icecost.get(n - 1) * b);
			IceCreamBean icebean = null;

			try {
				fis = new FileInputStream("iceCream.txt");
				ois = new ObjectInputStream(fis);
				icecreams = (List<IceCreamBean>) ois.readObject();
				for (IceCreamBean p : icecreams) {
					// System.out.println(p.getPqty()-a4);

					p.setPqty(p.getPqty() - b);
					icebean = p;
					icecreams.add(icebean);
				}

				// AdminStockImpl dao=new AdminStockImpl();
				fos = new FileOutputStream("iceCream.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(icecreams);
				oos.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.out
					.println(ice.get(n - 1) + "   =    " + icecost.get(n - 1));
			System.out.println("how much Quantity u want");
			int b1 = sc.nextInt();
			bill = icecost.get(n - 1) * b1;
			System.out.println(icecost.get(n - 1) * b1);
			try {
				fis = new FileInputStream("iceCream.txt");
				ois = new ObjectInputStream(fis);
				icecreams = (List<IceCreamBean>) ois.readObject();
				for (IceCreamBean p : icecreams) {
					// System.out.println(p.getPqty()-a4);

					p.setPqty(p.getPqty() - b1);
					icebean = p;
					icecreams.add(icebean);
				}

				// AdminStockImpl dao=new AdminStockImpl();
				fos = new FileOutputStream("iceCream.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(icecreams);
				oos.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out
					.println(ice.get(n - 1) + "   =    " + icecost.get(n - 1));
			System.out.println("how much Quantity u want");
			int b2 = sc.nextInt();
			bill = icecost.get(n - 1) * b2;
			System.out.println(icecost.get(n - 1) * b2);
			break;
		case 4:
			System.out
					.println(ice.get(n - 1) + "   =    " + icecost.get(n - 1));
			System.out.println("how much Quantity u want");
			int b3 = sc.nextInt();
			bill = icecost.get(n - 1) * b3;
			System.out.println(icecost.get(n - 1) * b3);
			break;
		case 5:
			System.out
					.println(ice.get(n - 1) + "   =    " + icecost.get(n - 1));
			System.out.println("how much Quantity u want");
			int b4 = sc.nextInt();
			bill = icecost.get(n - 1) * b4;
			System.out.println(icecost.get(n - 1) * b4);
			break;
		default:
			System.out.println("Choose between 1-5");
		}
	}

	@Override
	public void softDrinkMenu() {
		// TODO Auto-generated method stub
		List<String> drink = new ArrayList<String>();
		List<Integer> drinkcost = new ArrayList<Integer>();
		System.out.println("---------pizza Menu--------------");
		System.out.println("1)Pulpy Orange     =" + "Rs.99");
		System.out.println("2)Thums Up    =" + "Rs.90");
		System.out.println("3)Maaza     =" + "Rs.119");
		System.out.println("4)Mountain Dew  =" + "Rs.49");
		System.out.println("5)Mosambi     =" + "Rs.109");
		System.out.println("Enter Your choice");
		drink.add("Pulpy Orange");
		drink.add("Thums Up ");
		drink.add("Maaza  ");
		drink.add("Mountain Dew");
		drink.add("Mosambi");
		drinkcost.add(99);
		drinkcost.add(90);
		drinkcost.add(119);
		drinkcost.add(49);
		drinkcost.add(109);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println(drink.get(n - 1) + "   =    "
					+ drinkcost.get(n - 1));
			System.out.println("how much Quantity u want");
			int c = sc.nextInt();
			bill = drinkcost.get(n - 1) * c;
			System.out.println(drinkcost.get(n - 1) * c);

			break;
		case 2:
			System.out.println(drink.get(n - 1) + "   =    "
					+ drinkcost.get(n - 1));
			System.out.println("how much Quantity u want");
			int c1 = sc.nextInt();
			bill = drinkcost.get(n - 1) * c1;
			System.out.println(drinkcost.get(n - 1) * c1);
			break;
		case 3:
			System.out.println(drink.get(n - 1) + "   =    "
					+ drinkcost.get(n - 1));
			System.out.println("how much Quantity u want");
			int c2 = sc.nextInt();
			bill = drinkcost.get(n - 1) * c2;
			System.out.println(drinkcost.get(n - 1) * c2);
			break;
		case 4:
			System.out.println(drink.get(n - 1) + "   =    "
					+ drinkcost.get(n - 1));
			System.out.println("how much Quantity u want");
			int c3 = sc.nextInt();
			bill = drinkcost.get(n - 1) * c3;
			System.out.println(drinkcost.get(n - 1) * c3);
			break;
		case 5:
			System.out.println(drink.get(n - 1) + "   =    "
					+ drinkcost.get(n - 1));
			System.out.println("how much Quantity u want");
			int c4 = sc.nextInt();
			bill = drinkcost.get(n - 1) * c4;
			System.out.println(drinkcost.get(n - 1) * c4);
			break;
		default:
			System.out.println("Choose between 1-5");
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
	public List<PizzaBean> viewPizzas() {
		// TODO Auto-generated method stub
		try {
			ois = new ObjectInputStream(new FileInputStream("pizza.txt"));
			pizza = (List<PizzaBean>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizza;
	}

	@Override
	public void selectedPizzas() {
		// TODO Auto-generated method stub
		try {
			pizzas = new ArrayList<PizzaBean>();
			fis = new FileInputStream("pizza.txt");
			ois = new ObjectInputStream(fis);
			pizzas = (List<PizzaBean>) ois.readObject();
			System.out.println("PID" + "\t" + "PIZZA_NAME" + "\t" + "PRICE"
					+ "\t" + "QTY");
			System.out.println("---------------------------");
			/*
			 * for (PizzaBean p : pizzas) { System.out.println(p); }
			 */tempList = new ArrayList<PizzaBean>();
			pi = new PizzaBean();
			System.out.println("---------pizza Menu--------------");
			for (PizzaBean p2 : pizzas) {

				System.out.println(p2.getpId() + "        " + p2.getpName()
						+ "      =     " + p2.getpPrice());
				// if(p2.getpName().equals("paneer"))
				// System.out.println(p2.getpName() + p2.getpPrice());
			}
			/*
			 * System.out.println("Mushroom pizza     =" + "Rs.79");
			 * System.out.println("Chicken pizza     =" + "Rs.149");
			 * System.out.println("DoubleCheese pizza     =" + "Rs.179");
			 */
			System.out.println("Enter Selected Pizza pId");
			pi.setpId(sc.nextInt());
			System.out.println("Enter Selected pizza pqty");
			pi.setPqty(sc.nextInt());

			for (PizzaBean p1 : pizzas) {

				if (p1.getpId() == pi.getpId()) {

					System.out.println("----------------------------");
					System.out.println("----------PIZZAHUT----------");
					System.out.println("----------------------------");
					System.out.println("|Pizza Id     |    " + p1.getpId()
							+ "|");
					System.out.println("|Pizza Name   |    " + p1.getpName()
							+ "|");
					System.out.println("|Pizza Qty    |    "
							+ (p1.getPqty() - pi.getPqty()) + "|");
					System.out.println("-----------------------------");
					System.out.println("|Total        |    "
							+ (p1.getpPrice() * pi.getPqty()) + "|");
					System.out.println("----------------------------");
					p1.setPqty(p1.getPqty() - pi.getPqty());
					tempList.add(p1);
				} else {
					tempList.add(p1);
				}
			}
			fos = new FileOutputStream(original);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(tempList);
			original.delete();
			tempFile.renameTo(original);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<IceCreamBean> viewIceCreams() {
		// TODO Auto-generated method stub
		try {
			ois = new ObjectInputStream(new FileInputStream("icecream.txt"));

			icecream = (List<IceCreamBean>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return icecream;

	}

	@Override
	public void selectedIceCream() {
		// TODO Auto-generated method stub
		try {
			icecreams = new ArrayList<IceCreamBean>();
			fis = new FileInputStream("iceCream.txt");
			ois = new ObjectInputStream(fis);
			icecreams = (List<IceCreamBean>) ois.readObject();
			System.out.println("iceID" + "\t" + "ice_NAME" + "\t" + "IcePRICE"
					+ "\t" + "IceQTY");
			System.out.println("---------------------------");
			for (IceCreamBean p : icecreams) {
				System.out.println(p);
			}
			tempList1 = new ArrayList<IceCreamBean>();
			icb = new IceCreamBean();
			System.out.println("---------IceCream Menu--------------");
			for (IceCreamBean p2 : icecreams) {
				System.out.println(p2.getIceId() + "        " + p2.getIceName()
						+ "      =     " + p2.getIceprice());
			}
			/*
			 * System.out.println("Butter Scotch     =" + "Rs.89");
			 * System.out.println("Coconut Flavour    =" + "Rs.69");
			 * System.out.println("Black Forest     =" + "Rs.79");
			 * System.out.println("Magnum    =" + "Rs.149");
			 * System.out.println("Oreo Flavour     =" + "Rs.179");
			 */
			System.out.println("Enter Selected iceName");
			icb.setIceId(sc.nextInt());
			System.out.println("Enter Selected iceqty");
			icb.setPqty(sc.nextInt());

			for (IceCreamBean p1 : icecreams) {

				if (p1.getIceId() == icb.getIceId()) {

					System.out.println("----------------------------");
					System.out.println("----------PIZZAHUT----------");
					System.out.println("----------------------------");
					System.out.println("|Ice Id     |    " + p1.getIceId()
							+ "|");
					System.out.println("|Ice Name   |    " + p1.getIceName()
							+ "|");
					System.out.println("|Ice Qty    |    "
							+ (p1.getPqty() - icb.getPqty()) + "|");
					System.out.println("-----------------------------");
					System.out.println("|Total        |    "
							+ (p1.getIceprice() * icb.getPqty()) + "|");
					System.out.println("----------------------------");
					p1.setPqty(p1.getPqty() - pi.getPqty());
					tempList1.add(p1);
				} else {
					tempList1.add(p1);
				}
			}
			fos = new FileOutputStream(original);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(tempList1);
			original.delete();
			tempFile1.renameTo(original1);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SoftDrinkBean> viewSoftDrinks() {
		// TODO Auto-generated method stub
		try {
			ois = new ObjectInputStream(new FileInputStream("softDrink.txt"));
			drink = (List<SoftDrinkBean>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return drink;

	}

	@Override
	public void SelectedSoftDrink() {
		// TODO Auto-generated method stub
		try {
			drink = new ArrayList<SoftDrinkBean>();
			fis = new FileInputStream("SoftDrink.txt");
			ois = new ObjectInputStream(fis);
			drink = (List<SoftDrinkBean>) ois.readObject();
			System.out.println("drinkID" + "\t" + "drink_NAME" + "\t"
					+ "drinkPRICE" + "\t" + "drinkQTY");
			System.out.println("---------------------------");
			for (SoftDrinkBean p : drink) {
				System.out.println(p);
			}
			tempList2 = new ArrayList<SoftDrinkBean>();
			sd = new SoftDrinkBean();
			System.out.println("---------SoftDrink Menu--------------");
			for (SoftDrinkBean p2 : drink) {
				System.out.println(p2.getsId() + "        " + p2.getsName()
						+ "      =     " + p2.getsPrice());
			}
			/*
			 * System.out.println("Pulpy Orange     =" + "Rs.99");
			 * System.out.println("Thums Up    =" + "Rs.90");
			 * System.out.println("Maaza     =" + "Rs.119");
			 * System.out.println("Mountain Dew  =" + "Rs.49");
			 * System.out.println("Mosambi     =" + "Rs.109");
			 */System.out.println("Enter Selected softDrink Id");
			sd.setsId(sc.nextInt());
			System.out.println("Enter Selected SoftDrink qty");
			sd.setSqty(sc.nextInt());
			for (SoftDrinkBean p1 : drink) {

				if (p1.getsId() == sd.getsId()) {

					System.out.println("----------------------------");
					System.out.println("----------PIZZAHUT----------");
					System.out.println("----------------------------");
					System.out.println("|drink Id     |    " + p1.getsId()
							+ "|");
					System.out.println("|drink Name   |    " + p1.getsName()
							+ "|");
					System.out.println("|drink Qty    |    "
							+ (p1.getSqty() - sd.getSqty()) + "|");
					System.out.println("-----------------------------");
					System.out.println("|Total        |    "
							+ (p1.getsPrice() * sd.getSqty()) + "|");
					System.out.println("----------------------------");
					p1.setSqty(p1.getSqty() - sd.getSqty());
					tempList2.add(p1);
				} else {
					tempList2.add(p1);
				}
			}
			fos = new FileOutputStream(original);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(tempList2);
			original.delete();
			tempFile2.renameTo(original2);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
