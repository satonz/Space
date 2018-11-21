package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Activity;

public interface ActivityMapper {
	int deleteByPrimaryKey(Integer actId);

	int insert(Activity record);

	int insertSelective(Activity record);

	Activity selectByPrimaryKey(Integer actId);

	List<Activity> selectByRoomId(Integer roomId);

	int count(@Param("retrieval") String retrieval);

	List<Activity> selectBy(@Param("retrieval") String retrieval, @Param("page") Page page);

	int updateByPrimaryKeySelective(Activity record);

	int updateByPrimaryKeyWithBLOBs(Activity record);

	int updateByPrimaryKey(Activity record);

	List<Activity> selectForeshowActs();

	List<Activity> getPassActsByPage(space.util.Page page);

	int getPassActCount();
}