package com.ecomm.models;

public class Product {
	
	private int p_id;
	private String p_name;
	private double  price;
	private Category cat_id;
	private String availability;
	private int quantity;
	
	
	public Product() {
		
	}
	
	public Product(int p_id, String p_name, double price, Category cat_id, String availability,int quantity) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.price = price;
		this.cat_id = cat_id;
		this.availability = availability;
		this.quantity=quantity;
	}
	
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCat_id() {
		return cat_id;
	}
	public void setCat_id(Category cat_id) {
		this.cat_id = cat_id;
	}
	public String getAvailability() {
		return availability;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setAvailability(String availability) {
	    if (availability.equalsIgnoreCase("IN STOCK") || availability.equalsIgnoreCase("OUT OF STOCK")) {
	        this.availability = availability.toUpperCase();
	    } else {
	        throw new IllegalArgumentException("Invalid availability status. Only 'IN STOCK' or 'OUT OF STOCK' allowed.");
	    }
	}



	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", price=" + price + ", cat_id=" + cat_id
				+ ", availability=" + availability + "]";
	}
	
	

}
