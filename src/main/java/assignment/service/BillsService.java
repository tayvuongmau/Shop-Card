package assignment.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import assignment.dto.Cart;
import assignment.entities.Bills;

@Service
public interface BillsService {
	
	public boolean addBills(Bills bills);
	
	public int getIDLastBills();
	
	public void addBillsDetail(HashMap<Integer, Cart> cart);
}
