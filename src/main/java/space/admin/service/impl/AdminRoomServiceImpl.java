package space.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminRoomService;
import space.admin.vo.Page;
import space.dao.BuildingMapper;
import space.dao.RoomMapper;
import space.po.Building;
import space.po.Room;

@Service("adminRoomService")
@Transactional
public class AdminRoomServiceImpl implements AdminRoomService {

	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private BuildingMapper buildingMapper;

	@Override
	public int save(Room room, int buildingId) {
		int result = roomMapper.countByBuildingIdAndNumber(buildingId, room.getRoomNumber());
		if (result == 0) {
			Building building = buildingMapper.selectByPrimaryKey(buildingId);
			room.setBuilding(building);
			result = roomMapper.insert(room);
		} else {
			// 已存在
			result = 0;
		}
		return result;
	}

	@Override
	public Room get(int roomId) {
		return roomMapper.selectByPrimaryKey(roomId);
	}

	@Override
	public int update(Room room) {
		return roomMapper.updateByPrimaryKey(room);
	}

	@Override
	public List<Room> getByBuildingId(int buildingId) {
		List<Room> rooms = roomMapper.selectByBuildingId(buildingId);
		return rooms;
	}

	@Override
	public int getTotalNumber(String retrieval, int buildingId) {
		return roomMapper.countByBuildingId(buildingId);
	}

	@Override
	public List<Room> get(String retrieval, int buildingId, Page page) {
		return roomMapper.selectByPageAndBuiId(buildingId, page);
	}

	@Override
	public int delete(int roomId) {
		return roomMapper.deleteByPrimaryKey(roomId);
	}

}
