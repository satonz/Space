package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyId);
    
    List<Reply> selectByCommentId(Integer commentId);
    
    List<Reply> selectByUserId(Integer userId);
    
    int count(@Param("retrieval")String retrieval);

    List<Reply> selectBy(@Param("retrieval")String retrieval, @Param("page")Page page);
    
    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}