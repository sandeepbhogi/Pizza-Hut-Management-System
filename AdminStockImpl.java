package com.PizzaHut.Implementation;

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

public  class AdminStockImpl implements PizzaInterface, SoftDrinkInterface,
		IceCreamInterface {
	Scanner sc = new Scanner(System.in);
	File original = new File("pizza.txt");
	File tempFile = new File("temp.txt");
	File original1 = new File("iceCream.txt");
	File tempFile1 = new File("temp1.txt");
	File original2 = new File("softDrink.txt");
	File tempFile2 = new File("temp2.txt");
	FileInputStream fis = null;
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	List<SoftDrinkBean> drink = new ArrayList<SoftDrinkBean>();
	List<SoftDrinkBean> tempList2 = null;
	List<PizzaBean> pizza = new ArrayList<PizzaBean>();
	List<PizzaBean> tempList = null;
	List<IceCreamBean> tempList1 = null;
	List<IceCreamBean> iceCream = new ArrayList<IceCreamBean>();

	@Override
	public void addIceCreamProduct() {
		// TODO Auto-generated method stub
		try {
			oos = new ObjectOutputStream(new FileOutputStream("iceCream.txt"));
					int flag = 1;
			while (flag == 1) {
				System.out.println("Enter your iceid");
				int iceId = sc.nextInt();
				System.out.println("Enter your icename");
				String iceName = sc.next();
				System.out.println("Enter your iceprice");
				double icePrice = sc.nextDouble();
				System.out.println("enter icequantity");
				int iceqty = sc.nextInt();
				IceCreamBean icb = new IceCreamBean(iceId, iceName, icePrice,
						iceqty);
				iceCream.add(icb);
				System.out
						.println("Do you want to add one more record press 1 otherwise any number");
				flag = sc.nextInt();
			}
			
				oos.writeObject(iceCream);
				oos.flush();
				oos.close();
				System.out.println("----IceCreams succesfully updated");
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

	@Override
	public List<IceCreamBean> viewIceCreamDetails() {
		// TODO Auto-generated method stub
		try {
			ois = new ObjectInputStream(new FileInputStream("iceCream.txt"));
			iceCream = (List<IceCreamBean>) ois.readObject();
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
		return iceCream;
	}

	@Override
	public void updateIceCreamRecord(int iceId) {
		// TODO Auto-generated method stub
		try {
			fis = new FileInputStream(original1);
			ois = new ObjectInputStream(fis);
			fos = new FileOutputStream(tempFile1);
			oos = new ObjectOutputStream(fos);

	
		List<IceCreamBean> updateList1 = new ArrayList<IceCreamBean>();

		
			updateList1 = (List<IceCreamBean>) ois.readObject();
			for (IceCreamBean p : updateList1) {
				if (p.getIceId() == iceId) {
					System.out
							.println("select \n1.pname \n2.pprice\n3.pqty you want to update");
					int n = sc.nextInt();
					switch (n) {
					case 1:
						System.out.println("Enter new Icecream name");
						p.setIceName(sc.next());
						break;
					case 2:
						System.out.println("Enter new Icecream Price");
						p.setIceprice(sc.nextDouble());
						break;
					case 3:
						System.out.println("Enter new Icecream Quantity");
						p.setPqty(sc.nextInt());
						break;
					default:
						System.out.println("choose between 1-3");
						break;
					}
					tempList1 = new ArrayList<IceCreamBean>();
					tempList1.add(p);
				} else {
					tempList1.add(p);
				}
			}
			fos=new FileOutputStream(tempFile1);
			oos=new ObjectOutputStream(oos);
				oos.writeObject(tempList1);
				original1.delete();
				tempFile1.renameTo(original);
			
		
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

		
	}

	@Override
	public void deleteIceCreamRecord(int iceId) {
		// TODO Auto-generated method stub
		tempList1 = new ArrayList<IceCreamBean>();
		try {
			fis = new FileInputStream(original1);
			ois = new ObjectInputStream(fis);
			iceCream = (List<IceCreamBean>) ois.readObject();
			for (IceCreamBean p : iceCream) {
				if (p.getIceId() == iceId) {

				} else {
					tempList1.add(p);
				}
				fos = new FileOutputStream(tempFile1);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(tempList1);
				original1.delete();
				tempFile1.renameTo(original1);
			}
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
		System.out.println("iceCream deleted Successfully");

	}

	@Override
	public void addSoftDrink() {
		// TODO Auto-generated method stub
		try {
			oos = new ObjectOutputStream(new FileOutputStream("softDrink.txt"));
		
			int flag = 1;
			while (flag == 1) {
				System.out.println("Enter your sid");
				int sId = sc.nextInt();
				System.out.println("Enter your sname");
				String sName = sc.next();
				System.out.println("Enter your sprice");
				double sPrice = sc.nextDouble();
				System.out.println("enter icequantity");
				int sqty = sc.nextInt();
				SoftDrinkBean sdb = new SoftDrinkBean(sId, sName, sPrice, sqty);
				drink.add(sdb);
				System.out
						.println("Do you want to add one more record press 1 otherwise any number");
				flag = sc.nextInt();
			}
			
				oos.writeObject(drink);
				oos.flush();
				oos.close();
				System.out.println("----SoftDrinks succesfully added");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	

	@Override
	public List<SoftDrinkBean> viewSoftDrinkDetails() {
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
	public void updateSoftDrinkRecord(int sId) {
		// TODO Auto-generated method stub
		try {
			fis = new FileInputStream(original2);
			ois = new ObjectInputStream(fis);
			fos = new FileOutputStream(tempFile2);
			oos = new ObjectOutputStream(fos);
		
		List<SoftDrinkBean>updateList=new ArrayList<SoftDrinkBean>();
		
			updateList=(List<SoftDrinkBean>)ois.readObject();
			for(SoftDrinkBean s:updateList){
				if(s.getsId()==sId){
					System.out
					.println("select \n1.pname \n2.pprice\n3.pqty you want to update");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter new drink name");
				s.setsName(sc.next());
				break;
			case 2:
				System.out.println("Enter new drink Price");
				s.setsPrice(sc.nextDouble());
				break;
			case 3:
				System.out.println("Enter new drink Quantity");
				s.setSqty(sc.nextInt());
				break;
			default:
				System.out.println("choose between 1-3");
				break;
			}
			tempList2 = new ArrayList<SoftDrinkBean>();
			tempList2.add(s);
		} else {
			tempList2.add(s);
		}
				fos=new FileOutputStream(tempFile2);
				oos=new ObjectOutputStream(oos);
				
		oos.writeObject(tempList2);
		original.delete();
		tempFile.renameTo(original);
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println("------------------SoftDrink Updated successfully------------");
	}

	@Override
	public void deleteSoftDrinkRecord(int sId) {
		// TODO Auto-generated method stub
		tempList2 = new ArrayList<SoftDrinkBean>();
		try {
			fis = new FileInputStream(original2);
			ois = new ObjectInputStream(fis);
			drink = (List<SoftDrinkBean>) ois.readObject();
			for (SoftDrinkBean s: drink) {
				if ( s.getsId()== sId) {

				} else {
					tempList2.add(s);
				}
				fos = new FileOutputStream(tempFile2);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(tempList2);
				original.delete();
				tempFile2.renameTo(original2);
			}
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
		System.out.println("SoftDrink deleted Successfully");

	}

	@Override
	public void addProduct() {
		// TODO Auto-generated method stub

		try {
			oos = new ObjectOutputStream(new FileOutputStream("pizza.txt"));
		
			int flag = 1;
			while (flag == 1) {
				System.out.println("Enter your Pid");
				int pId = sc.nextInt();
				System.out.println("Enter your pname");
				String pName = sc.next();
				System.out.println("Enter your pprice");
				int pPrice = sc.nextInt();
				System.out.println("enter quantity");
				int pqty = sc.nextInt();
				PizzaBean pb = new PizzaBean(pId, pName, pPrice, pqty);
				pizza.add(pb);
				System.out
						.println("Do you want to add one more record press 1 otherwise any number");
				flag = sc.nextInt();
			}
				oos.writeObject(pizza);
				oos.flush();
				oos.close();
				System.out.println("----Pizzas succesfully added----------");
		}
			 catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PizzaBean> viewPizzaDetails() {
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
	public void updatePizzaRecord(int pId) {
		// TODO Auto-generated method stub
		try {
			fis = new FileInputStream(original);
			ois = new ObjectInputStream(fis);
			fos = new FileOutputStream(tempFile);
			oos = new ObjectOutputStream(fos);

		
		List<PizzaBean> updateList = new ArrayList<PizzaBean>();

		
			updateList = (List<PizzaBean>) ois.readObject();
			for (PizzaBean p : updateList) {
				if (p.getpId() == pId) {
					System.out
							.println("select \n1.pname \n2.pprice\n3.pqty you want to update");
					int n = sc.nextInt();
					switch (n) {
					case 1:
						System.out.println("Enter new pizza name");
						p.setpName(sc.next());
						break;
					case 2:
						System.out.println("Enter new Pizza Price");
						p.setpPrice(sc.nextInt());
						break;
					case 3:
						System.out.println("Enter new pizza Quantity");
						p.setPqty(sc.nextInt());
						break;
					default:
						System.out.println("choose between 1-3");
						break;
					}
					tempList = new ArrayList<PizzaBean>();
					tempList.add(p);
				} else {
					tempList.add(p);
				}
				fos=new FileOutputStream(tempFile);
				oos=new ObjectOutputStream(oos);
				
				oos.writeObject(tempList);
				original.delete();
				tempFile.renameTo(original);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pizza Updated Successfully");
	}

	@Override
	public void deletePizzaRecord(int pId) {
		// TODO Auto-generated method stub
		tempList = new ArrayList<PizzaBean>();
		try {
			fis = new FileInputStream(original);
			ois = new ObjectInputStream(fis);
			pizza = (List<PizzaBean>) ois.readObject();
			for (PizzaBean p : pizza) {
				if (p.getpId() == pId) {

				} else {
					tempList.add(p);
				}
				fos = new FileOutputStream(tempFile);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(tempList);
				original.delete();
				tempFile.renameTo(original);
				oos.flush();
			}
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
		System.out.println("Pizza deleted Successfully");

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
PizzaHut.main(null);
	}

	
	@Override
	public void billGenerate() {
		// TODO Auto-generated method stub
		
	}

	

}
