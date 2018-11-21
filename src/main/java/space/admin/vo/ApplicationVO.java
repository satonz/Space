package space.admin.vo;

import java.util.Date;

import space.po.Application;
import space.po.Building;
import space.po.Room;

public class ApplicationVO {

	private int id;// 记录id
	private String username;// 申请人、老师、社团、学院
	private String space;// 申请的场地，类型为(教学楼、8B、101)
	private String content;// 申请备注信息
	private Date startTime;// 申请成功开始使用时间
	private Date endTime;// 申请成功结束使用时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public ApplicationVO(Application application) {
		id = application.getAppId();
		try {
			username = "(认证名)" + application.getUser().getAuthentication().getInfName();
		} catch (Exception e) {
			username = "(用户名)" + application.getUser().getUsername();
		}
		try {
			Room room = application.getRoom();
			Building building = room.getBuilding();
			int type = building.getBuiType();
			String buildingType = type == 0 ? "教学楼" : (type == 1 ? "实验楼" : "综合楼");
			space = buildingType + "、" + building.getBuiName() + "、" + room.getRoomNumber();
		} catch (Exception e) {
		}
		content = application.getAppInfo();
		startTime = application.getAppStartTime();
		endTime = application.getAppEndTime();
	}

}
