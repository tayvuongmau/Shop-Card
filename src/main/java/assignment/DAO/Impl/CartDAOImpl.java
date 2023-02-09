package assignment.DAO.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assignment.DAO.CartDAO;
import assignment.DAO.ProductsDAO;
import assignment.dto.Cart;
import assignment.entities.Products;

@Repository
public class CartDAOImpl implements CartDAO{
	@Autowired
	ProductsDAO productsDAO;

	@Override
	public HashMap<Integer, Cart> addCart(Integer id, HashMap<Integer, Cart> cart) {
		Cart itemCart = new Cart();
		Products products = productsDAO.getProductById(id);
		if(products != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProducts().getProduct_price());
		}else {
			itemCart.setProducts(products);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(products.getProduct_price());
		}
		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Integer, Cart> editCart(Integer id, Integer quanty, HashMap<Integer, Cart> cart) {
		if(cart == null) {
			return cart;
		}
		Cart itemCart = new Cart();
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + quanty);
			Integer totalPrice = itemCart.getQuantity() * itemCart.getProducts().getProduct_price();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Integer, Cart> deleteCart(Integer id, HashMap<Integer, Cart> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	@Override
	public Integer totalQuanty(HashMap<Integer, Cart> cart) {
		Integer totalQuanty = 0;
		for(Map.Entry<Integer, Cart> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuantity();
		}
		return totalQuanty;
	}

	@Override
	public Integer totalPrice(HashMap<Integer, Cart> cart) {
		Integer totalPrice = 0;
		for(Map.Entry<Integer, Cart> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
