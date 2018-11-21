package space.po;

import java.util.Date;
import java.util.List;

public class Comment {
	private Integer commentId;

	private String commentContent;

	private Date commentTime;

	/*
	 * 评论者
	 */
	private User user;

	/*
	 * 评论所对应的活动
	 */
	private Activity activity;
	/*
	 * 评论的回复
	 */
	private List<Reply> replies;

	public Comment() {
		super();
	}

	public Comment(String commentContent, Date commentTime, User user, Activity activity) {
		super();
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.user = user;
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + ", commentTime=" + commentTime + ", user=" + user
				+ ", activity=" + activity + "]";
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent == null ? null : commentContent.trim();
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
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

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
}