package space.po;

import java.util.Date;

public class Reply {
	private Integer replyId;

	private String replyContent;

	private Date replyTime;

	/*
	 * 回复的用户
	 */
	private User user;

	/*
	 * 该回复所属的评论，评论是直接属于活动的，回复是评论的回复，现有评论才有评论的回复
	 */
	private Comment comment;

	public Reply() {
		super();
	}

	public Reply(String replyContent, Date replyTime, User user, Comment comment) {
		super();
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.user = user;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyTime=" + replyTime + ", user="
				+ user + ", comment=" + comment + "]";
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent == null ? null : replyContent.trim();
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
}