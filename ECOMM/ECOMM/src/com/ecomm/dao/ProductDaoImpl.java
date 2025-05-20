package com.ecomm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Category;
import com.ecomm.models.Product;
import com.ecomm.util.DBUtil;
import com.lms.exception.InvalidInputException;

public class ProductDaoImpl implements ProductDao
{
	Connection conn=DBUtil.connect();
	

	public void insertProduct(Product prod) throws SQLException,InvalidInputException {
		String query="insert into Product (pname,price,category_id,Avaialable,Quantity) values (?,?,?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(query);
		if(prod.getP_name().isEmpty()|| prod.getPrice()<0||prod.getQuantity()<0) {
			throw new InvalidInputException("Invalid Input");
		}
		ps.setString(1, prod.getP_name());
		ps.setDouble(2, prod.getPrice());
		ps.setInt(3, prod.getCat_id().getCat_id());
		ps.setString(4,prod.getAvailability());
		ps.setInt(5, prod.getQuantity());
		int i=ps.executeUpdate();
		if( i>0) {
			System.out.println("Product inserted successfully");
		}
		
		
	}
	
	@Override
	public void getbycatid(Category cat) throws SQLException, IdnotfoundException {
		// TODO Auto-generated method stub
		String query="select * from product join Category on category.id=product.Category_id where category_id=?";
		PreparedStatement ps=conn.prepareStatement(query);	
		ps.setInt(1, cat.getCat_id());
		ResultSet rs=ps.executeQuery();
		boolean found=false;
		while(rs.next()) {
			
			found=true;
			System.out.println("ID: "+rs.getInt("id")+"\nPRODUCT NAME: "+rs.getString("Pname")+"\nPrice: "+rs.getDouble("Price")+"\nAvailable: "+rs.getString("Avaialable")+"\nCategory: "+rs.getString("Category_name"));
			System.out.println("****************************************");
		}
		 if (!found) {
		        throw new IdnotfoundException("Id not found");
		    }
		
	}
	
}
