package assignment.service;

import org.springframework.stereotype.Service;

import assignment.entities.User;

@Service
public interface UserService {
	
	public boolean insertUser(User user);
	public boolean exists(String username);
}
