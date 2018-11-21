package space.admin.vo;

/**
 * 对应发布活动信息表单
 *
 */
public class ActivityInformation {

	private String title;

	private String startTime;

	private String endTime;

	private String imgPath;

	private String detail;

	private String addTime;

	private String introduce;

	private int roomId;

	private Integer tickets;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Integer getTickets() {
		return tickets;
	}

	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "ActivityInformation [title=" + title + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", imgPath=" + imgPath + ", detail=" + detail + ", addTime=" + addTime + ", introduce=" + introduce
				+ ", roomId=" + roomId + ", tickets=" + tickets + "]";
	}

}
