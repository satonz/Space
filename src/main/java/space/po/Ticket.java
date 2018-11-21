package space.po;

import java.util.Date;

public class Ticket {
	private Integer ticketId;

	private Date ticketTime;

	/*
	 * 入场券所属的用户
	 */
	private User user;

	/*
	 * 入场券所属的活动，一个活动可以有多张入场券
	 */
	private Activity activity;

	public Ticket() {
		super();
	}

	public Ticket(Date ticketTime, User user, Activity activity) {
		super();
		this.ticketTime = ticketTime;
		this.user = user;
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketTime=" + ticketTime + ", user=" + user + ", activity="
				+ activity + "]";
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Date getTicketTime() {
		return ticketTime;
	}

	public void setTicketTime(Date ticketTime) {
		this.ticketTime = ticketTime;
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
}