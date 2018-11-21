package space.service;

import space.po.Authentication;
import space.po.User;

public interface AuthenticationService {

	Authentication save(Authentication authentication);
	
	Authentication selectByUser(User user);

	int delete(Authentication authentication);
}
