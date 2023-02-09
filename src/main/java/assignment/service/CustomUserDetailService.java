package assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import assignment.DAO.UserDAO;
import assignment.entities.CustomUserDetails;
import assignment.entities.User;
import assignment.entities.User_Role;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority>	authorities = new ArrayList<>();
		Set<User_Role> roles = user.getUserRole();
		for(User_Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(authorities, user.getUserName(), user.getPassWord(), user.getEmail(), 
																	user.getTelephone(),user.getBirthday(), true, true, true, true);
		return customUserDetails;
	}
	
}
