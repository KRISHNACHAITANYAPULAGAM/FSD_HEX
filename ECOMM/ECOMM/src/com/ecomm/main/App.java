package com.ecomm.main;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Category;
import com.ecomm.models.Customer;
import com.ecomm.models.Product;
import com.ecomm.service.ProductService;
import com.ecomm.service.PurchaseService;
import com.lms.exception.InvalidInputException;

public class App {
	public static void main(String[]args) {
	ProductService PRDI=new ProductService();
	PurchaseService PDI=new PurchaseService();
	Category c=new Category();
	Scanner sc=new Scanner(System.in);
	while(true) {
	System.out.println("*************ECOMM***********");
	System.out.println("1. Insert Product into DB\n2. Fetch all products by given Category id\n3. Insert new record into purchase\n0. Exit");
	int choice=sc.nextInt();
	sc.nextLine();
	switch(choice) {
	
	case 1:
		Product p=new Product();
		try {
		System.out.println("Enter the product details: ");
		System.out.println("Enter the Product Name: ");
		p.setP_name(sc.nextLine());
		System.out.println("Enter the Product Price: ");
		p.setPrice(sc.nextDouble());
		sc.nextLine();
		System.out.println("Enter the Product category ID: ");
		c.setCat_id(sc.nextInt());
		sc.nextLine();
		p.setCat_id(c);
		System.out.println("Enter the Status of Product(IN STOCK/OUT OF STOCK)");
		p.setAvailability(sc.nextLine().toUpperCase());
		System.out.println("Enter the Quantity of the product: ");
		p.setQuantity(sc.nextInt());
		sc.nextLine();
		
		PRDI.insertproduct(p);
		} catch (SQLException|InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		break;
	
	case 2:
		System.out.println("Enter the Category ID: ");
		c.setCat_id(sc.nextInt());
		try {
				PRDI.getbycatid(c);
			} catch (IdnotfoundException|SQLException e) {
				
				System.out.println(e.getMessage());
			}
		
		break;
		
	case 3:
		Customer cu=new Customer();
		Product pr=new Product();
		System.out.println("Enter the purchase details: ");
		System.out.println("Enter the customer id: ");
		cu.setC_id(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter the Product ID: ");
		pr.setP_id(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter the Quantity: ");
		int quant = sc.nextInt();
		sc.nextLine();
		
		try {
			try {
				PDI.insert(cu, pr, quant);
			} catch (IdnotfoundException | InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		break;
	case 0:
		System.out.println("Thank You Exiting.....");
		sc.close();
		return;
	default:
		System.out.println("Invalid Choice.Select Again...");
	}
	
	}
}}
