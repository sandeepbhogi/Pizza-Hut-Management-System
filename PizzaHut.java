package com.PizzaHut.Dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.PizzaHut.Customer.CustomerLogin;
public class PizzaHut {
	
	public static void main(String[] args)throws InputMismatchException {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
AdmindaoImpl ad=new AdmindaoImpl();
CustomerLogin customer=new CustomerLogin();
System.out.println("-------------------Welcome to pizzaHut------------------");
System.out.println("1)Admin");
System.out.println("2)Customer");
System.out.println("3)StockMenu");
System.out.println("----------------------------------------------------------");
System.out.println("Enter your choice");
int n=sc.nextInt();
switch(n){
case 1:
	ad.AdminMenu();
	break;
case 2:
	customer.customerMenu();
	break;

}
	}

}
