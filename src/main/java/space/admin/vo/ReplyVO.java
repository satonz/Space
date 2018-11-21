package space.admin.vo;

import java.util.Date;

import space.po.Reply;

public class ReplyVO {

	private int id;
	private String commentContent;
	private String content;
	private String userName;
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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

	public ReplyVO(Reply reply) {
		id = reply.getReplyId();
		commentContent = reply.getComment().getCommentContent();
		content = reply.getReplyContent();
		userName = reply.getUser().getEmail();
		time = reply.getReplyTime();
	}

}
