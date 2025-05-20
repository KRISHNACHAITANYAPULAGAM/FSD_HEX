package com.ecomm.service;

import java.sql.SQLException;

import com.ecomm.dao.PurchaseDaoImpl;
import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Customer;
import com.ecomm.models.Product;
import com.lms.exception.InvalidInputException;

public class PurchaseService {
	
	PurchaseDaoImpl pdi=new PurchaseDaoImpl();
	public void insert(Customer cust,Product prod,int quantity) throws SQLException, IdnotfoundException, InvalidInputException {
		
		pdi.insertPurchase(cust, prod, quantity);
		
	}
	
	

}
