package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);
    
    List<Comment> selectByActivityId(Integer activityId);
    
    List<Comment> selectByUserId(Integer userId);
    
    int count(@Param("retrieval")String retrieval);
    
    List<Comment> selectBy(@Param("retrieval")String retrieval, @Param("page")Page page);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}