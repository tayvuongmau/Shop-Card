package assignment.DAO.Impl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assignment.DAO.BillsDAO;
import assignment.entities.Bills;
import assignment.entities.BillsDetail;

@Repository
public class BillsDAOImpl implements BillsDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBills(Bills bills) {
		 Session session = sessionFactory.openSession();
		 try {
			session.beginTransaction();
			session.save(bills);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public int getIDLastBills() {
		Session session = sessionFactory.openSession();
		try {
			Query query =   (Query) session.createQuery("select id from Bills order by id desc");
			query.setFirstResult(0);
			query.setMaxResults(1);
			return Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	@Override
	public boolean addBillsDetail(BillsDetail billsDetail) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(billsDetail);
			session.getTransaction().commit();
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
