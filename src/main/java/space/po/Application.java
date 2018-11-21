package space.po;

import java.util.Date;

public class Application {
	private Integer appId;

	private Date appTime;

	private Date appStartTime;

	private Date appEndTime;

	private Boolean appStatus;

	private Boolean appIsDealed;

	private String appInfo;

	private User user;

	private Room room;

	public Application() {
		super();
	}

	public Application(Date appTime, Date appStartTime, Date appEndTime, Boolean appStatus, Boolean appIsDealed,
			String appInfo, User user, Room room) {
		super();
		this.appTime = appTime;
		this.appStartTime = appStartTime;
		this.appEndTime = appEndTime;
		this.appStatus = appStatus;
		this.appIsDealed = appIsDealed;
		this.appInfo = appInfo;
		this.user = user;
		this.room = room;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", appTime=" + appTime + ", appStartTime=" + appStartTime
				+ ", appEndTime=" + appEndTime + ", appStatus=" + appStatus + ", appIsDealed=" + appIsDealed
				+ ", appInfo=" + appInfo + ", user=" + user + ", room=" + room + "]";
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Date getAppTime() {
		return appTime;
	}

	public void setAppTime(Date appTime) {
		this.appTime = appTime;
	}

	public Date getAppStartTime() {
		return appStartTime;
	}

	public void setAppStartTime(Date appStartTime) {
		this.appStartTime = appStartTime;
	}

	public Date getAppEndTime() {
		return appEndTime;
	}

	public void setAppEndTime(Date appEndTime) {
		this.appEndTime = appEndTime;
	}

	public Boolean getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Boolean appStatus) {
		this.appStatus = appStatus;
	}

	public Boolean getAppIsDealed() {
		return appIsDealed;
	}

	public void setAppIsDealed(Boolean appIsDealed) {
		this.appIsDealed = appIsDealed;
	}

	public String getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo == null ? null : appInfo.trim();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}