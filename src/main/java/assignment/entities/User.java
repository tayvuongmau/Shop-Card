package assignment.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
	@NotEmpty(message="Tên tài khoản không hợp lệ")
	private String userName;
	
	@Column(name = "password")
	@NotEmpty(message="Mật khẩu không hợp lệ")
	private String passWord;
	
	@Column(name = "email")
	@Email(message = "Email không đúng định dạng", regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")
	@NotEmpty(message = "Email không hợp lệ")
	private String email;
	
	@Column(name = "telephone")
	@NotEmpty(message = "Số điện thoại không hợp lệ")
	private String telephone;
	
	@Column(name = "birthday")
	@NotNull(message="Năm sinh không hợp lệ")
	@DateTimeFormat(pattern = "yyyy-MM-dd")			//java tự kiểm tra định dạng ngày tháng xem có đúng không mà không cần parse nữa
	@Past(message="Năm sinh không đúng định dạng")
	private Date birthday;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<User_Role> userRole;
	public User() {
		super();
	}
	public User(Integer id, String userName, String passWord, String email, String telephone, Date birthday,
			Set<User_Role> userRole) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.telephone = telephone;
		this.birthday = birthday;
		this.userRole = userRole;
	}
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public String getPassWord() {return passWord;}
	public void setPassWord(String passWord) {this.passWord = passWord;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getTelephone() {return telephone;}
	public void setTelephone(String telephone) {this.telephone = telephone;}
	public Date getBirthday() {return birthday;}
	public void setBirthday(Date birthday) {this.birthday = birthday;}
	public Set<User_Role> getUserRole() {return userRole;}
	public void setUserRole(Set<User_Role> userRole) {this.userRole = userRole;}
		
}
