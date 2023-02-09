package assignment.DAO;

import java.util.List;

import assignment.entities.Products;

public interface ProductsDAO {
	public List<Products> getProductsByPage(Integer indexPage);
	public List<Products> getProductsByName(String productName);
	public List<Products> getProductsByStreng(String productdes);
	public List<Products> getProductsByIntelligent(String productdes);
	public List<Products> getProductsByAgility(String productdes);
	public List<Products> searchProductsByName(String productName);
	public int getTotalProduct();
	public int getTotalProductByStreng(String productdes);
	public int getTotalProductByIntelligent(String productdes);
	public int getTotalProductByAgility(String productdes);
	public Products getProductById(Integer product_id);
	public Products findProductByName(String product_name);
	public boolean insertProduct(Products products);
	public boolean updateProduct(Products products);
	public boolean deleteProduct(String product_name);
	
}
