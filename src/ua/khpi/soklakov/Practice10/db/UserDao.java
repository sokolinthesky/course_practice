package ua.khpi.soklakov.Practice10.db;

import ua.khpi.soklakov.Practice10.entity.User;

public interface UserDao {
	
	User findUserByLogin(String login);
	void editUser(User user);

}
