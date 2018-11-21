package space.po;

import java.util.List;

public class Room {
	private Integer roomId;

	private Integer roomNumber;

	private Integer roomCapacity;

	private Building building;

	private List<Application> applications;

	private List<Activity> activities;

	public Room() {
		super();
	}

	public Room(Integer roomNumber, Integer roomCapacity, Building building) {
		super();
		this.roomNumber = roomNumber;
		this.roomCapacity = roomCapacity;
		this.building = building;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomCapacity=" + roomCapacity
				+ ", building=" + building + "]";
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
}