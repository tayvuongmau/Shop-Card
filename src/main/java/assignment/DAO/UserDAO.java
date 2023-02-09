package assignment.DAO;

import java.util.List;

import assignment.entities.User;

public interface UserDAO {
	public List<User> getAllUser(Integer indexPage);
	public User findByUserName(String username);
	public Integer countTotalUser();
	public boolean insertUser(User user);
	public boolean deleteUserByUserName(String username);
	public boolean exists(String username);
	
}
