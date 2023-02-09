package assignment.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment.DAO.BillsDAO;
import assignment.dto.Cart;
import assignment.entities.Bills;
import assignment.entities.BillsDetail;
import assignment.service.BillsService;

@Service
public class BillsServiceImpl implements BillsService{
	
	@Autowired
	BillsDAO billsDAO;

	@Override
	public boolean addBills(Bills bills) {
		return billsDAO.addBills(bills);
	}

	@Override
	public int getIDLastBills() {
		return billsDAO.getIDLastBills();
	}

	@Override
	public void addBillsDetail(HashMap<Integer, Cart> cart) {	
		
		int idBills = billsDAO.getIDLastBills();
		
		for(Map.Entry<Integer, Cart> itemCart : cart.entrySet()) {
			BillsDetail billsDetail = new BillsDetail();
			billsDetail.setId_bills(idBills);
			billsDetail.setId_product(itemCart.getValue().getProducts().getProduct_id());
			billsDetail.setBillsdetail_quanty(itemCart.getValue().getQuantity());
			billsDetail.setBillsdetail_total(itemCart.getValue().getTotalPrice());
			billsDAO.addBillsDetail(billsDetail);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
