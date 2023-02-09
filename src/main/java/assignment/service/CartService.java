package assignment.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import assignment.dto.Cart;

@Service
public interface CartService {
	
	public HashMap<Integer, Cart> addCart(Integer id, HashMap<Integer, Cart> cart);
	
	public HashMap<Integer, Cart> editCart(Integer id, Integer quanty, HashMap<Integer, Cart> cart);
	
	public HashMap<Integer, Cart> deleteCart(Integer id, HashMap<Integer, Cart> cart);
	
	public Integer totalQuanty(HashMap<Integer, Cart> cart);
	
	public Integer totalPrice(HashMap<Integer, Cart> cart);
}
