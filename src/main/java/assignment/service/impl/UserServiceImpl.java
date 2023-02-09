package assignment.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment.DAO.UserDAO;
import assignment.entities.User;
import assignment.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public boolean insertUser(User user) {
		user.setPassWord(BCrypt.hashpw(user.getPassWord(), BCrypt.gensalt(12)));
		return userDAO.insertUser(user);
	}

	@Override
	public boolean exists(String username) {
		return userDAO.exists(username);
	}
	
	

}
