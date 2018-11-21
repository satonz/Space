package space.admin.vo;

import java.util.Date;

import space.po.Activity;

public class ActivityVO {

	private int id;// 对应记录id
	private String title;// 标题
	private String introduce;// 介绍
	private String path;// 宣传主图片路径
	private Date startTime;// 活动开始时间
	private Date endTime;// 活动结束时间
	private int tickets;// 剩余票数

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public ActivityVO(Activity activity) {
		id = activity.getActId();
		title = activity.getActTitle();
		introduce = activity.getActIntroduce();
		path = activity.getActImgPath();
		startTime = activity.getActStartTime();
		endTime = activity.getActEndTime();
		tickets = activity.getActTicket() - activity.getTickets().size();
	}

}
