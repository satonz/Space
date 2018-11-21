package space.dao;

import org.apache.ibatis.annotations.Param;

import space.po.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);
    
    Admin selectByEmailAndPassword(@Param("email")String email, @Param("password")String password);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}