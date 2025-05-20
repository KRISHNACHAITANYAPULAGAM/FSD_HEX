package com.ecomm.dao;

import java.sql.SQLException;

import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Category;
import com.ecomm.models.Product;
import com.lms.exception.InvalidInputException;

public interface ProductDao {
	
	void insertProduct(Product prod) throws SQLException, InvalidInputException;
	void getbycatid(Category cat)throws SQLException, IdnotfoundException;

}
