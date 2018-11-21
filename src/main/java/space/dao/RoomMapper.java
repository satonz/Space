package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Room;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);
    
    Room selectByRoomNumber(Integer roomNumber);
    
    List<Room> selectByBuildingId(Integer buildingId);
    
    int countByBuildingId(Integer buildingId);
    
    int countByBuildingIdAndNumber(@Param("buildingId")Integer buildingId, @Param("number")Integer number);

    List<Room> selectByPageAndBuiId(@Param("buildingId")Integer buildingId, @Param("page")Page page);
    
    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}