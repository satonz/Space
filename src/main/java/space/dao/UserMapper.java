package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	List<User> selectByName(String username);

	List<User> selectByEmail(String email);
	
	int countByRetrieval(@Param("retrieval")String retrieval);
	
	List<User> selectBytRetrievalAndPage(@Param("retrieval")String retrieval, @Param("page")Page page);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}