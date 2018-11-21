package space.po;

import java.util.Date;

public class Sysinform {
	private Integer sysinformId;

	private String sysinformInfo;

	private Date sysinformTime;

	private User user;

	private boolean isReaded;

	public Sysinform() {
		super();
	}

	public Sysinform(Integer sysinformId, String sysinformInfo, Date sysinformTime, User user, boolean isReaded) {
		super();
		this.sysinformId = sysinformId;
		this.sysinformInfo = sysinformInfo;
		this.sysinformTime = sysinformTime;
		this.user = user;
		this.isReaded = isReaded;
	}

	@Override
	public String toString() {
		return "Sysinform [sysinformId=" + sysinformId + ", sysinformInfo=" + sysinformInfo + ", sysinformTime="
				+ sysinformTime + ", user=" + user + ", isReaded=" + isReaded + "]";
	}

	public Integer getSysinformId() {
		return sysinformId;
	}

	public void setSysinformId(Integer sysinformId) {
		this.sysinformId = sysinformId;
	}

	public String getSysinformInfo() {
		return sysinformInfo;
	}

	public void setSysinformInfo(String sysinformInfo) {
		this.sysinformInfo = sysinformInfo == null ? null : sysinformInfo.trim();
	}

	public Date getSysinformTime() {
		return sysinformTime;
	}

	public void setSysinformTime(Date sysinformTime) {
		this.sysinformTime = sysinformTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isReaded() {
		return isReaded;
	}

	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}

}