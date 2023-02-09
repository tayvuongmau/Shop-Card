package assignment.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment.DAO.CartDAO;
import assignment.dto.Cart;
import assignment.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartDAO cartDAO;

	@Override
	public HashMap<Integer, Cart> addCart(Integer id, HashMap<Integer, Cart> cart) {
		return cartDAO.addCart(id, cart);
	}

	@Override
	public HashMap<Integer, Cart> editCart(Integer id, Integer quanty, HashMap<Integer, Cart> cart) {
		return cartDAO.editCart(id, quanty, cart);
	}

	@Override
	public HashMap<Integer, Cart> deleteCart(Integer id, HashMap<Integer, Cart> cart) {
		return cartDAO.deleteCart(id, cart);
	}

	@Override
	public Integer totalQuanty(HashMap<Integer, Cart> cart) {
		return cartDAO.totalQuanty(cart);
	}

	@Override
	public Integer totalPrice(HashMap<Integer, Cart> cart) {
		return cartDAO.totalPrice(cart);
	}
	
}
