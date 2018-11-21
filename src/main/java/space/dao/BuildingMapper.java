package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Building;

public interface BuildingMapper {
	int deleteByPrimaryKey(Integer buiId);

	int insert(Building record);

	int insertSelective(Building record);

	Building selectByPrimaryKey(Integer buiId);

	int countByRetrievalAndType(@Param("retrieval") String retrieval, @Param("type") int type);

	List<Building> selectByPageAndRetrieval(@Param("retrieval") String retrieval, @Param("type") int type, @Param("page") Page page);

	List<Building> selectByType(int type);
	
	int selectByBuildingName(String buildingName);

	int updateByPrimaryKeySelective(Building record);

	int updateByPrimaryKeyWithBLOBs(Building record);

	int updateByPrimaryKey(Building record);
}