package space.po;

import java.util.Date;

public class Action {
	private Integer actionId;

	private String actionName;

	private String actionIp;

	private Date actionTime;

	private User user;

	public Action() {
		super();
	}

	public Action(Integer actionId, String actionName, String actionIp, Date actionTime, User user) {
		super();
		this.actionId = actionId;
		this.actionName = actionName;
		this.actionIp = actionIp;
		this.actionTime = actionTime;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Action [actionId=" + actionId + ", actionName=" + actionName + ", actionIp=" + actionIp
				+ ", actionTime=" + actionTime + ", user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName == null ? null : actionName.trim();
	}

	public String getActionIp() {
		return actionIp;
	}

	public void setActionIp(String actionIp) {
		this.actionIp = actionIp == null ? null : actionIp.trim();
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

}