package space.admin.vo;

import space.po.Authentication;
import space.po.User;

public class UserVO {

	private int id;
	private String userName;// 用户名
	private String account;// 账号
	private String realName;// 如果认证，则真实姓名，否则，未认证

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public UserVO(User user) {
		id = user.getUserId();
		userName = user.getUsername();
		account = user.getEmail();
		Authentication authentication = user.getAuthentication();
		if (authentication != null) {
			realName = authentication.getInfName();
		} else {
			realName = "未认证";
		}
	}

}
