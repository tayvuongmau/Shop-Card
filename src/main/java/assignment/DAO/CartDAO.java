package assignment.DAO;

import java.util.HashMap;

import assignment.dto.Cart;

public interface CartDAO {
	
	public HashMap<Integer, Cart> addCart(Integer id, HashMap<Integer, Cart> cart);
	
	public HashMap<Integer, Cart> editCart(Integer id, Integer quanty, HashMap<Integer, Cart> cart);
	
	public HashMap<Integer, Cart> deleteCart(Integer id, HashMap<Integer, Cart> cart);
	
	public Integer totalQuanty(HashMap<Integer, Cart> cart);
	
	public Integer totalPrice(HashMap<Integer, Cart> cart);
	
}
