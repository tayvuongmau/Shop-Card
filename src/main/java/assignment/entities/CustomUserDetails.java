package assignment.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 5958220333193080208L;
	
	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;
	private String email;
	private String telephone;
	private Date birthday;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	
	public CustomUserDetails() {}

	public CustomUserDetails(Collection<? extends GrantedAuthority> authorities, String username, String password,
			String email, String telephone, Date birthday, boolean enabled, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired) {
		super();
		this.authorities = authorities;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.birthday = birthday;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getTelephone() {return telephone;}
	public void setTelephone(String telephone) {this.telephone = telephone;}
	public Date getBirthday() {return birthday;}
	public void setBirthday(Date birthday) {this.birthday = birthday;}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {this.authorities = authorities;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	public void setEnabled(boolean enabled) {this.enabled = enabled;}
	public void setAccountNonExpired(boolean accountNonExpired) {this.accountNonExpired = accountNonExpired;}
	public void setAccountNonLocked(boolean accountNonLocked) {this.accountNonLocked = accountNonLocked;}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {this.credentialsNonExpired = credentialsNonExpired;}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {return authorities;}

	@Override
	public boolean isAccountNonExpired() {return accountNonExpired;}

	@Override
	public boolean isAccountNonLocked() {return accountNonLocked;}

	@Override
	public boolean isCredentialsNonExpired() {return credentialsNonExpired;}

	@Override
	public boolean isEnabled() {return enabled;}

	@Override
	public String getPassword() {return password;}

	@Override
	public String getUsername() {return username;}
}
