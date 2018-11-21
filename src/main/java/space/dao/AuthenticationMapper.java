package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Authentication;

public interface AuthenticationMapper {
	int deleteByPrimaryKey(Integer infId);

	int insert(Authentication record);

	int insertSelective(Authentication record);

	Authentication selectByPrimaryKey(Integer infId);

	List<Authentication> selectByUserId(Integer userId);
	
	/**
	 * 
	 * @param retrieval
	 * @param aType 0班级/1老师/2社团/3院系
	 * @param status true 已通过, false 未通过
	 * @param deal true 已处理, false 未处理
	 * @return
	 */
	int countBy(@Param("retrieval")String retrieval, @Param("aType")int aType, @Param("status")boolean status, @Param("deal")boolean deal);

	List<Authentication> selectBy(@Param("retrieval")String retrieval, @Param("aType")int aType, @Param("status")boolean status, @Param("deal")boolean deal, @Param("page")Page page);
	
	int updateByPrimaryKeySelective(Authentication record);

	int updateByPrimaryKeyWithBLOBs(Authentication record);

	int updateByPrimaryKey(Authentication record);
}