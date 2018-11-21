package space.admin.service;

import java.util.List;

import space.admin.vo.Page;
import space.po.Room;

/**
 * 房间相关业务
 *
 */
public interface AdminRoomService {

	/**
	 * 新增房间
	 * 
	 * @param room
	 * @param buildingId
	 * @return 1新增成功, 0存在相同buildingId和number记录
	 */
	int save(Room room, int buildingId);

	/**
	 * 删除roomId的记录
	 * 
	 * @param roomId
	 * @return
	 */
	int delete(int roomId);

	Room get(int roomId);

	/**
	 * 更新房间信息
	 * 
	 * @param room
	 * @return 1成功
	 */
	int update(Room room);

	List<Room> getByBuildingId(int buildingId);

	int getTotalNumber(String retrieval, int buildingId);

	List<Room> get(String retrieval, int buildingId, Page page);
}
