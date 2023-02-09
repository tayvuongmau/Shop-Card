package assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;		
	@Column(name="product_name")
	private String product_name;
	@Column(name="product_des")
	private String product_des;
	@Column(name="product_price")
	private Integer product_price;
	@Column(name="product_src")
	private String product_src;
	@Column(name="product_type")
	private String product_type;
	@Column(name="number")
	private Integer number;
	
	public Products() {
		super();
	}
	public Products(Integer product_id, String product_name, String product_des, Integer product_price, String product_src,
			String product_type, Integer number) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_des = product_des;
		this.product_price = product_price;
		this.product_src = product_src;
		this.product_type = product_type;
		this.number = number;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_des() {
		return product_des;
	}
	public void setProduct_des(String product_des) {
		this.product_des = product_des;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	public String getProduct_src() {
		return product_src;
	}
	public void setProduct_src(String product_src) {
		this.product_src = product_src;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
