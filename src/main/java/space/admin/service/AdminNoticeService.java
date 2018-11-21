package space.admin.service;

import java.util.List;

import space.admin.vo.Page;
import space.po.Notice;

/**
 * 公告相关业务
 *
 */
public interface AdminNoticeService {

	/**
	 * 发布一条公告
	 * 
	 * @param notice
	 * @return
	 */
	int save(Notice notice);

	/**
	 * 标题含有retrieval的公告总数
	 * 
	 * @param retrieval
	 * @return
	 */
	int totalNumber(String retrieval);

	/**
	 * 获取对应page并且满足retrieval条件的公告记录
	 * 
	 * @param retrieval
	 * @param page
	 * @return
	 */
	List<Notice> getNotices(String retrieval, Page page);

	/**
	 * 删除数据库notice表记录id为noticeId的记录
	 * 
	 * @param noticeId
	 * @return
	 */
	int delete(int noticeId);
}
