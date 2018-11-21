package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.UserMapper;
import space.po.User;
import space.service.UserService;
import space.util.MyMD5;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper um;

	@Override
	public User login(User user) {
		List<User> existUser = null;
		if (user.getUsername() != null || user.getUsername() != "") {
			existUser = um.selectByName(user.getUsername());
			if (existUser.size() == 0) {
				existUser = um.selectByEmail(user.getUsername());
			}
		} else {
			return null;
		}

		/*
		 * 可以根据用户名或邮箱查询用户
		 */
		if (existUser.size() == 0) {
			return null;
		}
		boolean pswEQ = MyMD5.encrypt(user.getPassword()).equals(existUser.get(0).getPassword());
		if (pswEQ == true) {
			return existUser.get(0);
		}
		return null;
	}

	@Override
	public User regist(User user) {
		user.setPassword(MyMD5.encrypt(user.getPassword()));
		um.insert(user);
		return user;
	}

	@Override
	public User selectByName(String username) {
		List<User> users = um.selectByName(username);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public User selectByEmail(String email) {

		List<User> users = um.selectByEmail(email);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public int update(User user) {

		return um.updateByPrimaryKey(user);
	}

}
