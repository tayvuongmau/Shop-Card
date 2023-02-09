package assignment.dto;

import assignment.entities.Products;

public class Cart {
	private Products products;
	private Integer quantity;
	private Integer totalPrice;
	
	public Cart() {
	}
	
	public Cart(Products products, Integer quantity, Integer totalPrice) {
		this.products = products;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
}
