package com.ecomm.service;

import java.sql.SQLException;

import com.ecomm.dao.ProductDaoImpl;
import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Category;
import com.ecomm.models.Product;
import com.lms.exception.InvalidInputException;

public class ProductService {

	ProductDaoImpl pdi=new ProductDaoImpl();
	
	public void insertproduct(Product prod) throws SQLException, InvalidInputException {

		pdi.insertProduct(prod);
		
	}
	
	public void getbycatid(Category cat) throws SQLException, IdnotfoundException {
		
		pdi.getbycatid(cat);
	}
	
	
}
