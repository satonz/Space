package space.dao;

import space.po.Action;

public interface ActionMapper {
	int deleteByPrimaryKey(Integer actionId);

	int insert(Action record);

	int insertSelective(Action record);

	Action selectByPrimaryKey(Integer actionId);

	int updateByPrimaryKeySelective(Action record);

	int updateByPrimaryKey(Action record);

	int countAll();

	int countToday();
}