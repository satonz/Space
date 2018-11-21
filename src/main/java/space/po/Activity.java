package space.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import space.admin.vo.ActivityInformation;

public class Activity {
    private Integer actId;

    private String actTitle;

    private Date actStartTime;

    private Date actEndTime;

    private String actImgPath;

    private Integer actTicket;

    private String actDetail;

    private Date actAddTime;

    private String actIntroduce;
    
    private Room room;
    
    private List<Ticket> tickets;
    
    private List<Comment> comments;
    
    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle == null ? null : actTitle.trim();
    }

    public Date getActStartTime() {
        return actStartTime;
    }

    public void setActStartTime(Date actStartTime) {
        this.actStartTime = actStartTime;
    }

    public Date getActEndTime() {
        return actEndTime;
    }

    public void setActEndTime(Date actEndTime) {
        this.actEndTime = actEndTime;
    }

    public String getActImgPath() {
        return actImgPath;
    }

    public void setActImgPath(String actImgPath) {
        this.actImgPath = actImgPath == null ? null : actImgPath.trim();
    }

    public Integer getActTicket() {
        return actTicket;
    }

    public void setActTicket(Integer actTicket) {
        this.actTicket = actTicket;
    }

    public String getActDetail() {
        return actDetail;
    }

    public void setActDetail(String actDetail) {
        this.actDetail = actDetail == null ? null : actDetail.trim();
    }

    public Date getActAddTime() {
        return actAddTime;
    }

    public void setActAddTime(Date actAddTime) {
        this.actAddTime = actAddTime;
    }

    public String getActIntroduce() {
        return actIntroduce;
    }

    public void setActIntroduce(String actIntroduce) {
        this.actIntroduce = actIntroduce == null ? null : actIntroduce.trim();
    }

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}

	public Activity(ActivityInformation activityInformation) throws ParseException {
		super();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.actTitle = activityInformation.getTitle();
		this.actStartTime = simpleDateFormat.parse(activityInformation.getStartTime());
		this.actEndTime = simpleDateFormat.parse(activityInformation.getEndTime());
		this.actImgPath = activityInformation.getImgPath();
		this.actTicket = activityInformation.getTickets();
		this.actDetail = activityInformation.getDetail();
		this.actAddTime = new Date();
		this.actIntroduce = activityInformation.getIntroduce();
	}

	@Override
	public String toString() {
		return "Activity [actTitle=" + actTitle + ", actStartTime=" + actStartTime + ", actEndTime=" + actEndTime
				+ ", actImgPath=" + actImgPath + ", actTicket=" + actTicket + ", actDetail=" + actDetail
				+ ", actAddTime=" + actAddTime + ", actIntroduce=" + actIntroduce + "]";
	}
	
}