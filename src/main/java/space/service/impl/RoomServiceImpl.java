package space.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.RoomMapper;
import space.po.Room;
import space.service.RoomService;

@Service("roomService")
public class RoomServiceImpl implements RoomService{

	@Resource
	private RoomMapper rm;
	
	@Override
	public Room getRoomById(int roomId) {
		// TODO Auto-generated method stub
		return rm.selectByPrimaryKey(roomId);
	}

}
