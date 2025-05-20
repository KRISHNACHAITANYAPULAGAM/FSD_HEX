package com.ecomm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomm.exception.IdnotfoundException;
import com.ecomm.models.Customer;
import com.ecomm.models.Product;
import com.ecomm.models.ProductInfo;
import com.ecomm.util.DBUtil;
import com.lms.exception.InvalidInputException;

public class PurchaseDaoImpl implements PurchaseDao {
	Connection conn = DBUtil.connect();

	public ProductInfo getQuant(Product pr) throws SQLException, IdnotfoundException {
		String query = "select * from product where id = ?";
		int i = 0;
		int price = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, pr.getP_id());
			if (pr.getP_id() <= 0) {
				throw new InvalidInputException("Invalid Input");
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt("quantity");
				price = rs.getInt("price");

			}
			return new ProductInfo(price, i);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insertPurchase(Customer c, Product p, int Quantity) throws SQLException, IdnotfoundException, InvalidInputException {
		ProductInfo pi = null;
			pi = getQuant(p);
			if (pi == null) {
				throw new IdnotfoundException("ID not found");
			}
			if(Quantity<0) {
				throw new InvalidInputException("quantity cant be -ve");
			}

		if (pi.getQuantity() >= Quantity) {
			double amount = Quantity * pi.getPrice();
			String query = "INSERT INTO purchase (c_id, p_id, quantity, amount) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, c.getC_id());
			ps.setInt(2, p.getP_id());
			ps.setInt(3, Quantity);
			ps.setDouble(4, amount);
			if (pi.getQuantity() == Quantity) {
				System.out.println("Warning: You're purchasing the last items. Stock will be 0.");
			}
			
				reduceStock(p.getP_id(), Quantity);
			
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Insert successful");
			} else {
				System.out.println("Some error occurred. Try again.");
			}
			
		}
	}

	public void reduceStock(int prodId, int qty) throws SQLException, InvalidInputException {
		String update = "UPDATE product SET quantity = quantity - ? WHERE id = ?";

		PreparedStatement ps = conn.prepareStatement(update);

		if (qty < 0) {
			throw new InvalidInputException("Quantity should be greater than 0");
		}
		ps.setInt(1, qty);
		ps.setInt(2, prodId);
		ps.executeUpdate();

	}

}
