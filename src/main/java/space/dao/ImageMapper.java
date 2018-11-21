package space.dao;

import java.util.List;

import space.po.Image;

public interface ImageMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer imgId);
    
    List<Image> selectByAuthenticationId(Integer authenticationId);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
}