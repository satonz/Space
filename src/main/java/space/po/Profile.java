package space.po;

import java.util.Date;

public class Profile {
	// id
	private Integer pfId;
	// 手机号
	private String pfPhone;
	// 生日
	private Date pfBirth;
	// 头像路径
	private String pfAvatar;
	// QQ号
	private String pfQq;
	// 性别
	private String pfSex;
	// 真实年龄
	private String pfRealname;
	// 是否已激活
	private Boolean pfIsActive;
	// 一对一外键，所属的用户
	private User user;



	@Override
	public String toString() {
		return "Profile [pfId=" + pfId + ", pfPhone=" + pfPhone + ", pfBirth=" + pfBirth + ", pfAvatar=" + pfAvatar
				+ ", pfQq=" + pfQq + ", pfSex=" + pfSex + ", pfRealname=" + pfRealname + ", pfIsActive=" + pfIsActive
				+ ", user=" + user + "]";
	}



	public Profile() {
		super();
		this.pfIsActive = false;
	}
	
	

	public Profile(String pfPhone, Date pfBirth, String pfAvatar, String pfQq, String pfSex, String pfRealname,
			Boolean pfIsActive, User user) {
		super();
		this.pfPhone = pfPhone;
		this.pfBirth = pfBirth;
		this.pfAvatar = pfAvatar;
		this.pfQq = pfQq;
		this.pfSex = pfSex;
		this.pfRealname = pfRealname;
		this.pfIsActive = pfIsActive;
		this.user = user;
	}

	public Integer getPfId() {
		return pfId;
	}

	public void setPfId(Integer pfId) {
		this.pfId = pfId;
	}

	public String getPfPhone() {
		return pfPhone;
	}

	public void setPfPhone(String pfPhone) {
		this.pfPhone = pfPhone == null ? null : pfPhone.trim();
	}

	public Date getPfBirth() {
		return pfBirth;
	}

	public void setPfBirth(Date pfBirth) {
		this.pfBirth = pfBirth;
	}

	public String getPfAvatar() {
		return pfAvatar;
	}

	public void setPfAvatar(String pfAvatar) {
		this.pfAvatar = pfAvatar == null ? null : pfAvatar.trim();
	}

	public String getPfQq() {
		return pfQq;
	}

	public void setPfQq(String pfQq) {
		this.pfQq = pfQq == null ? null : pfQq.trim();
	}

	public String getPfSex() {
		return pfSex;
	}

	public void setPfSex(String pfSex) {
		this.pfSex = pfSex == null ? null : pfSex.trim();
	}

	public String getPfRealname() {
		return pfRealname;
	}

	public void setPfRealname(String pfRealname) {
		this.pfRealname = pfRealname == null ? null : pfRealname.trim();
	}

	public Boolean getPfIsActive() {
		return pfIsActive;
	}

	public void setPfIsActive(Boolean pfIsActive) {
		this.pfIsActive = pfIsActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}