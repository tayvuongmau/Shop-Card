package assignment.DAO;

import org.springframework.stereotype.Repository;

import assignment.entities.Bills;
import assignment.entities.BillsDetail;

@Repository
public interface BillsDAO {

	public boolean addBills(Bills bills);
	
	public int getIDLastBills();
	
	public boolean addBillsDetail(BillsDetail billsDetail);
	
}
