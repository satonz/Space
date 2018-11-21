package space.admin.vo;

import space.po.Room;

public class RoomVO {
	private Integer roomId;

	private Integer roomNumber;

	private Integer roomCapacity;

	public RoomVO(Room room) {
		roomId = room.getRoomId();
		roomNumber = room.getRoomNumber();
		roomCapacity = room.getRoomCapacity();
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
}
