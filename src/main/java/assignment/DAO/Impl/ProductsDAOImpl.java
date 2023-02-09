package assignment.DAO.Impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assignment.DAO.ProductsDAO;
import assignment.entities.Products;

@Repository
public class ProductsDAOImpl implements ProductsDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Products> getProductsByStreng(String productdes) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Products where product_des like :product_des").setParameter("product_des", productdes);
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Products> getProductsByIntelligent(String productdes) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Products where product_des like :product_des").setParameter("product_des", productdes);
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Products> getProductsByAgility(String productdes) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Products where product_des like :product_des").setParameter("product_des", productdes);
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public int getTotalProduct() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("select count(*) from Products");
			return Integer.parseInt(query.getSingleResult().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	@Override
	public Products getProductById(Integer product_id) {
		Session session = sessionFactory.openSession();
		try {
			Products products = (Products) session.createQuery("from Products where product_id like :id").setParameter("id", product_id).uniqueResult();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertProduct(Products products) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(products);
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
	public boolean updateProduct(Products products) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(products);
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
	public boolean deleteProduct(String product_name) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(findProductByName(product_name));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Products> getProductsByPage(Integer indexPage) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Products");
			int max = 3;
			query.setMaxResults(max);
			query.setFirstResult((indexPage - 1)*max);
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Products> getProductsByName(String productName) {
		return null;
	}

	@Override
	public List<Products> searchProductsByName(String productName) {
		Session session = sessionFactory.openSession();
		try {
			if(productName == null || productName.length() == 0) {
				productName = "%";
			}else{
				productName = "%" + productName + "%";
			}
			List list = session.createQuery("from Products where product_name like :name").setParameter("name", productName).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Products findProductByName(String product_name) {
		Session session = sessionFactory.openSession();
		try {
			Products products = (Products) session.createQuery("from Products where product_name like :name").setParameter("name", product_name).uniqueResult();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public int getTotalProductByStreng(String productdes) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("select count(*) from Products where product_des like :productdes").setParameter("productdes", productdes);
			return Integer.parseInt(query.getSingleResult().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int getTotalProductByIntelligent(String productdes) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("select count(*) from Products where product_des like :productdes").setParameter("productdes", productdes);
			return Integer.parseInt(query.getSingleResult().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int getTotalProductByAgility(String productdes) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("select count(*) from Products where product_des like :productdes").setParameter("productdes", productdes);
			return Integer.parseInt(query.getSingleResult().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
