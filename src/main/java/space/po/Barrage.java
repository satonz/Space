package space.po;

import java.util.Date;

public class Barrage {
	private Integer barrId;

	private String barrInfo;

	private Date barrTime;

	private User user;

	private Activity activity;

	public Barrage() {
		super();
	}

	public Barrage(Integer barrId, String barrInfo, Date barrTime, User user, Activity activity) {
		super();
		this.barrId = barrId;
		this.barrInfo = barrInfo;
		this.barrTime = barrTime;
		this.user = user;
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Barrage [barrId=" + barrId + ", barrInfo=" + barrInfo + ", barrTime=" + barrTime + ", user=" + user
				+ ", activity=" + activity + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Integer getBarrId() {
		return barrId;
	}

	public void setBarrId(Integer barrId) {
		this.barrId = barrId;
	}

	public String getBarrInfo() {
		return barrInfo;
	}

	public void setBarrInfo(String barrInfo) {
		this.barrInfo = barrInfo == null ? null : barrInfo.trim();
	}

	public Date getBarrTime() {
		return barrTime;
	}

	public void setBarrTime(Date barrTime) {
		this.barrTime = barrTime;
	}

}