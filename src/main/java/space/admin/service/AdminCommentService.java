package space.admin.service;

import java.util.List;

import space.admin.vo.CommentVO;
import space.admin.vo.Page;

public interface AdminCommentService {

	/**
	 * 获取总数
	 * 
	 * @param retrieval
	 * @return
	 */
	int getTotalNumber(String retrieval);

	/**
	 * 获取满足条件总数
	 * 
	 * @param retrieval
	 * @param page
	 * @return
	 */
	List<CommentVO> get(String retrieval, Page page);

	/**
	 * 删除评论id为commentId的记录
	 * 
	 * @param commentId
	 * @return 成功返回1
	 */
	int delete(int commentId);

}
