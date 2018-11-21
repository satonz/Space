package space.po;

import java.util.List;

public class Building {
	public static final int CLASSBUILDING = 0;
	public static final int LABBUILDING = 1;
	public static final int COMPLEXBUILDING = 2;

	private Integer buiId;

	private String buiName;

	private Byte buiType;// 建筑类型 0 教室； 1 实验室； 2 综合楼；

	private String buiIntroduce;

	private List<Room> rooms;

	public Building() {
		super();
	}

	public Building(String buiName, Byte buiType, String buiIntroduce) {
		super();
		this.buiName = buiName;
		this.buiType = buiType;
		this.buiIntroduce = buiIntroduce;
	}

	@Override
	public String toString() {
		return "Building [buiId=" + buiId + ", buiName=" + buiName + ", buiType=" + buiType + ", buiIntroduce="
				+ buiIntroduce + "]";
	}

	public Integer getBuiId() {
		return buiId;
	}

	public void setBuiId(Integer buiId) {
		this.buiId = buiId;
	}

	public String getBuiName() {
		return buiName;
	}

	public void setBuiName(String buiName) {
		this.buiName = buiName == null ? null : buiName.trim();
	}

	public Byte getBuiType() {
		return buiType;
	}

	public void setBuiType(Byte buiType) {
		this.buiType = buiType;
	}

	public String getBuiIntroduce() {
		return buiIntroduce;
	}

	public void setBuiIntroduce(String buiIntroduce) {
		this.buiIntroduce = buiIntroduce == null ? null : buiIntroduce.trim();
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}