package space.po;

import java.util.Date;
import java.util.List;

public class Authentication {
	/*
	 * 认证类型，或用enum来表示？
	 */
	public static final Byte INF_CLASS = 1;
	public static final Byte INF_TEACHER = 2;
	public static final Byte INF_ASSOCIATION = 3;
	public static final Byte INF_INSTITUTE = 4;

	private Integer infId;

	private Byte infType;

	private String infName;

	private Date infTime;

	private Boolean infStatus;

	private Boolean infIsDealed;

	private String infIntroduce;

	private User user;

	private List<Image> images;

	// 将返回认证类型的字符串
	public static String getTypeToString(Byte infType) {
		String type = null;
		switch (infType) {
		case 1:
			type = "班级";
			break;
		case 2:
			type = "教师";
			break;
		case 3:
			type = "社团";
			break;
		case 4:
			type = "学院";
			break;
		}
		return type;
	}

	public Authentication() {
		super();
	}

	public Authentication(Byte infType, String infName, Date infTime, Boolean infStatus, Boolean infIsDealed,
			String infIntroduce, User user, List<Image> images) {
		super();
		this.infType = infType;
		this.infName = infName;
		this.infTime = infTime;
		this.infStatus = infStatus;
		this.infIsDealed = infIsDealed;
		this.infIntroduce = infIntroduce;
		this.user = user;
		this.images = images;
	}

	@Override
	public String toString() {
		return "Authentication [infId=" + infId + ", infType=" + infType + ", infName=" + infName + ", infTime="
				+ infTime + ", infStatus=" + infStatus + ", infIsDealed=" + infIsDealed + ", infIntroduce="
				+ infIntroduce;
	}

	public Integer getInfId() {
		return infId;
	}

	public void setInfId(Integer infId) {
		this.infId = infId;
	}

	public Byte getInfType() {
		return infType;
	}

	public void setInfType(Byte infType) {
		this.infType = infType;
	}

	public String getInfName() {
		return infName;
	}

	public void setInfName(String infName) {
		this.infName = infName == null ? null : infName.trim();
	}

	public Date getInfTime() {
		return infTime;
	}

	public void setInfTime(Date infTime) {
		this.infTime = infTime;
	}

	public Boolean getInfStatus() {
		return infStatus;
	}

	public void setInfStatus(Boolean infStatus) {
		this.infStatus = infStatus;
	}

	public Boolean getInfIsDealed() {
		return infIsDealed;
	}

	public void setInfIsDealed(Boolean infIsDealed) {
		this.infIsDealed = infIsDealed;
	}

	public String getInfIntroduce() {
		return infIntroduce;
	}

	public void setInfIntroduce(String infIntroduce) {
		this.infIntroduce = infIntroduce == null ? null : infIntroduce.trim();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}