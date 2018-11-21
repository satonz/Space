package space.admin.service;

import java.util.List;

import space.admin.vo.Page;
import space.admin.vo.UserVO;

public interface AdminUserService {

	/**
	 * 
	 * @param retrieval
	 * @param type
	 *            检索的账号类型：0全部，1学生，2老师，3社团，4学院，5未认证
	 * @return
	 */
	int getTotalNumber(String retrieval, int type);

	/**
	 * 
	 * @param retrieval
	 * @param type
	 *            检索的账号类型：0全部，1学生，2老师，3社团，4学院，5未认证
	 * @param page
	 * @return
	 */
	List<UserVO> get(String retrieval, int type, Page page);
}
