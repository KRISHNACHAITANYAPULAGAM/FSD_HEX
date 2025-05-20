package com.ecomm.models;

public class Category {
	private int cat_id;
	private String category_name;
	
	public Category() {
		
	}

	public Category(int cat_id, String category_name) {
		super();
		this.cat_id = cat_id;
		this.category_name = category_name;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "Category [cat_id=" + cat_id + ", category_name=" + category_name + "]";
	}
	

}
