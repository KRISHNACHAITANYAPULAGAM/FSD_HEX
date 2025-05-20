package com.ecomm.models;

public class ProductInfo {
	private int price;
	private int quantity;
	public ProductInfo() {
		
	}
	
	public ProductInfo(int price, int quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
