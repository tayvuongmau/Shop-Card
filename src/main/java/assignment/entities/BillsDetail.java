package assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "BillsDetail")
public class BillsDetail {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "id_product")
	private Integer id_product;
	
	@Column(name= "id_bills")
	private int id_bills;
	
	@Column(name= "billsdetail_quanty")
	private int billsdetail_quanty;
	
	@Column(name= "billsdetail_total")
	private double billsdetail_total;

	public BillsDetail() {
	}

	public BillsDetail(int id, Integer id_product, int id_bills, int billsdetail_quanty, double billsdetail_total) {
		this.id = id;
		this.id_product = id_product;
		this.id_bills = id_bills;
		this.billsdetail_quanty = billsdetail_quanty;
		this.billsdetail_total = billsdetail_total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	public int getId_bills() {
		return id_bills;
	}

	public void setId_bills(int id_bills) {
		this.id_bills = id_bills;
	}

	public int getBillsdetail_quanty() {
		return billsdetail_quanty;
	}

	public void setBillsdetail_quanty(int billsdetail_quanty) {
		this.billsdetail_quanty = billsdetail_quanty;
	}

	public double getBillsdetail_total() {
		return billsdetail_total;
	}

	public void setBillsdetail_total(double billsdetail_total) {
		this.billsdetail_total = billsdetail_total;
	}
	
	

}
