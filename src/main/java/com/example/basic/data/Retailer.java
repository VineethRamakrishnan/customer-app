package com.example.basic.data;

public class Retailer {
	
	private String organization;
	
	private String products;
	
	private String type;

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Retailer(String organization, String products, String type) {
		super();
		this.organization = organization;
		this.products = products;
		this.type = type;
	}

	public Retailer() {
	}
	
	
	
	
	

}
