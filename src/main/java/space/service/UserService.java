package space.service;

import space.po.User;

public interface UserService {

	User login(User user);

	User regist(User user);

	User selectByName(String username);
	
	User selectByEmail(String email);
	
	int update(User user);
	

}
