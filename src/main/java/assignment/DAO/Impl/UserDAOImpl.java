package assignment.DAO.Impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assignment.DAO.UserDAO;
import assignment.entities.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.createQuery("from User where userName = :userName").setParameter("userName", username).uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> getAllUser(Integer indexPage) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from User");
			int max = 5;
			query.setMaxResults(max);
			query.setFirstResult((indexPage-1)*max);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Integer countTotalUser() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("select count(*) from User");
			return Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(user);
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
	public boolean deleteUserByUserName(String username) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(findByUserName(username));
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
	public boolean exists(String username) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.createQuery("from User where username = :id").setParameter("id", username).uniqueResult();
			if(user == null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
