package space.admin.vo;

import java.util.Date;

import space.po.Comment;

public class CommentVO {

	private int id;
	private String actTitle;// 活动标题
	private String content;// 评论内容
	private String userName;// 作者名称
	private Date time;// 评论时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActTitle() {
		return actTitle;
	}

	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public CommentVO(Comment comment) {
		id = comment.getCommentId();
		actTitle = comment.getActivity().getActTitle();
		content = comment.getCommentContent();
		userName = comment.getUser().getEmail();
		time = comment.getCommentTime();
	}
}
