package com.ecomm.models;

public class Customer {
	private int c_id;
	private String c_name;
	private String address;
	private String contact_info;
	
	public Customer() {
		
	}
	public Customer(int id,String name,String address,String contact) {
		this.c_id=id;
		this.c_name=name;
		this.address=address;
		this.contact_info=contact;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_info() {
		return contact_info;
	}
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", address=" + address + ", contact_info="
				+ contact_info + "]";
	}
	
	

}
