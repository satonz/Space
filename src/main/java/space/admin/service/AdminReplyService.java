package space.admin.service;

import java.util.List;

import space.admin.vo.Page;
import space.admin.vo.ReplyVO;

public interface AdminReplyService {

	/**
	 * 获取总数
	 * 
	 * @param retrieval
	 * @return
	 */
	int getTotalNumber(String retrieval);

	List<ReplyVO> get(String retrieval, Page page);

	/**
	 * 删除评论id为commentId的记录
	 * 
	 * @param commentId
	 * @return 成功返回1
	 */
	int delete(int replyId);

}
