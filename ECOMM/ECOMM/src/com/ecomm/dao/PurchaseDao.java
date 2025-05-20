package com.ecomm.dao;

import java.sql.SQLException;

import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Customer;
import com.ecomm.models.Product;
import com.lms.exception.InvalidInputException;

public interface PurchaseDao {
	
	void insertPurchase(Customer c,Product p,int quant) throws SQLException, IdnotfoundException, InvalidInputException; 

}
