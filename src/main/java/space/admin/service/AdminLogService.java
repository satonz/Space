package space.admin.service;

import java.util.List;

import space.admin.vo.Page;

/**
 * 与日志相关的业务类 方法执行顺序从上到下
 * 
 */
public interface AdminLogService {

	List<String> getFileList(String path, int type);

	/**
	 * 获取搜索添加为retrieval日志类型为type文件的总数
	 * 
	 * @param retrieval
	 * @param type
	 * @return
	 */
	int getTotalNumber(String retrieval, List<String> fileList);

	/**
	 * 获取一页获取搜索添加为retrieval日志类型为type文件列表
	 * 
	 * @param retrieval
	 * @param type
	 * @param page
	 * @return
	 */
	List<String> list(String retrieval, Page page, List<String> fileList);

}
