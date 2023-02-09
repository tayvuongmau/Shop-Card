package assignment.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@OneToMany(mappedBy = "role")
	private Set<User_Role> roleUser;
	
	public Role() {
		super();
	}

	public Role(Integer id, String name, Set<User_Role> roleUser) {
		super();
		this.id = id;
		this.name = name;
		this.roleUser = roleUser;
	}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Set<User_Role> getRoleUser() {return roleUser;}
	public void setRoleUser(Set<User_Role> roleUser) {this.roleUser = roleUser;}
		
}
