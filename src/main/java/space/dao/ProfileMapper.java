package space.dao;

import space.po.Profile;

public interface ProfileMapper {
	int deleteByPrimaryKey(Integer pfId);

	int insert(Profile record);

	int insertSelective(Profile record);

	Profile selectByPrimaryKey(Integer pfId);

	int updateByPrimaryKeySelective(Profile record);

	int updateByPrimaryKey(Profile record);

	Profile selectByUserId(Integer userId);
}