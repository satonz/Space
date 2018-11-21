package space.dao;

import java.util.List;

import space.po.Sysinform;
import space.po.User;

public interface SysinformMapper {
    int deleteByPrimaryKey(Integer sysinformId);

    int insert(Sysinform record);

    int insertSelective(Sysinform record);

    Sysinform selectByPrimaryKey(Integer sysinformId);

    int updateByPrimaryKeySelective(Sysinform record);

    int updateByPrimaryKey(Sysinform record);

	int getUnReadNumByUser(User user);

	List<Sysinform> getAllByUser(User user);

	void updateAllToReaded(User user);
}