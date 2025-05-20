package com.Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecomm.dao.ProductDaoImpl;
import com.ecomm.dao.PurchaseDaoImpl;
import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Category;
import com.ecomm.models.Customer;
import com.ecomm.models.Product;
import com.lms.exception.InvalidInputException;

public class ECommTest {
	
	PurchaseDaoImpl pDI;
	ProductDaoImpl pdi;
	
	@BeforeEach
	public void inti() {
		pDI=new PurchaseDaoImpl();
		pdi=new ProductDaoImpl();
	}
	@Test
	public void Ecommtest() {
		Category cat=new Category();
		cat.setCat_id(2);
		
		try {
		pdi.getbycatid(cat);}
		catch(IdnotfoundException e) {
			assertEquals("No products for given Id",e.getMessage());
		}catch(SQLException e) {
			
		}
		
	}
	@Test
	public void ProductinsertExceptiontest() {
		Product prod=new Product();
		prod.setP_id(99);
		prod.setPrice(-99);
		prod.setAvailability("in stock");
		prod.setP_name("afadsfd");
		prod.setQuantity(-5);
		
		assertThrows(InvalidInputException.class,()->{pdi.insertProduct(prod);});
		
	}
	@Test
	public void insertPurchaseTest() {
		Product prod=new Product();
		Customer cust=new Customer();
		prod.setP_id(1);
		cust.setC_id(1);
		int quantity=-5;
		assertThrows(InvalidInputException.class,()->{pDI.insertPurchase(cust, prod, quantity);});
		
		
	}
	
	@Test
	public void insertPurchaseTestException() throws SQLException,IdnotfoundException {
		Product prod=new Product();
		Customer cust=new Customer();
		prod.setP_id(1);
		cust.setC_id(1);
		int quantity=-5;
			try {
				pDI.insertPurchase(cust, prod, quantity);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				assertEquals("quantity cant be -ve",e.getMessage().toLowerCase());
			}
			
		
		
		
	}
	
	
	

}
