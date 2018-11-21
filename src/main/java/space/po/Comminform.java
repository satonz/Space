package space.po;

import java.util.Date;

public class Comminform {
	private Integer comminformId;

	private Date comminformTime;

	private Comment comment;

	private User user;

	private boolean isReaded;

	public Comminform() {
		super();
	}

	public Comminform(Integer comminformId, Date comminformTime, Comment comment, User user, boolean isReaded) {
		super();
		this.comminformId = comminformId;
		this.comminformTime = comminformTime;
		this.comment = comment;
		this.user = user;
		this.isReaded = isReaded;
	}

	@Override
	public String toString() {
		return "Comminform [comminformId=" + comminformId + ", comminformTime=" + comminformTime + ", comment="
				+ comment + ", user=" + user + ", isReaded=" + isReaded + "]";
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
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

	public Integer getComminformId() {
		return comminformId;
	}

	public void setComminformId(Integer comminformId) {
		this.comminformId = comminformId;
	}

	public Date getComminformTime() {
		return comminformTime;
	}

	public void setComminformTime(Date comminformTime) {
		this.comminformTime = comminformTime;
	}

}