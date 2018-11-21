package space.dao;

import java.util.List;

import space.po.Comminform;
import space.po.User;

public interface ComminformMapper {
    int deleteByPrimaryKey(Integer comminformId);

    int insert(Comminform record);

    int insertSelective(Comminform record);

    Comminform selectByPrimaryKey(Integer comminformId);

    int updateByPrimaryKeySelective(Comminform record);

    int updateByPrimaryKey(Comminform record);

	int getUnReadNumByUser(User user);

	List<Comminform> getAllByUser(User user);

	void updateAllToReaded(User user);
}