package space.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Notice;

public interface NoticeMapper {
	int deleteByPrimaryKey(Integer noticeId);

	int insert(Notice record);

	int insertSelective(Notice record);

	Notice selectByPrimaryKey(Integer noticeId);

	int selectByRetrieval(String retrieval);

	List<Notice> selectByRetrievalAndPage(@Param("retrieval") String retrieval, @Param("page") Page page);

	int updateByPrimaryKeySelective(Notice record);

	int updateByPrimaryKey(Notice record);

	List<Notice> selectByPage(space.util.Page page);

	int getCount();
}