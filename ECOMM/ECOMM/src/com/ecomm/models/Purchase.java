package com.ecomm.models;

public class Purchase {

	private Customer c_id;
	private Product p_id;
	private int quantity;
	private double amount;
	
	public Purchase() {
		
	}

	public Purchase(Customer c_id, Product p_id, int quantity, double amount) {
		super();
		this.c_id = c_id;
		this.p_id = p_id;
		this.quantity = quantity;
		this.amount = amount;
	}

	public Customer getC_id() {
		return c_id;
	}

	public void setC_id(Customer c_id) {
		this.c_id = c_id;
	}

	public Product getP_id() {
		return p_id;
	}

	public void setP_id(Product p_id) {
		this.p_id = p_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Purchase [c_id=" + c_id + ", p_id=" + p_id + ", quantity=" + quantity + ", amount=" + amount + "]";
	}
	
	
}
