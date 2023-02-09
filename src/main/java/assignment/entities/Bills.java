package assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "Bills")
public class Bills {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "username")
	private String username;
	
	@Column(name= "telephone")
	private String telephone;
	
	@Column(name= "address")
	private String address;
	
	@Column(name= "bills_quanty")
	private int bills_quanty;
	
	@Column(name= "bills_total")
	private double bills_total;
	
	@Column(name= "note")
	private String note;

	public Bills() {
	}

	public Bills(int id, String username, String telephone, String address, int bills_quanty, double bills_total,String note) {
		this.id = id;
		this.username = username;
		this.telephone = telephone;
		this.address = address;
		this.bills_quanty = bills_quanty;
		this.bills_total = bills_total;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBills_quanty() {
		return bills_quanty;
	}

	public void setBills_quanty(int bills_quanty) {
		this.bills_quanty = bills_quanty;
	}

	public double getBills_total() {
		return bills_total;
	}

	public void setBills_total(double bills_total) {
		this.bills_total = bills_total;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
