package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.po.Activity;
import space.po.Barrage;

public interface BarrageMapper {
    int deleteByPrimaryKey(Integer barrId);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    Barrage selectByPrimaryKey(Integer barrId);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);

	List<Barrage> getLastNByAct(@Param("act") Activity act,@Param("n") int n);

	List<Barrage> getActRealTimeBass(@Param("act") Activity act,@Param("maxId")  int maxId);
}