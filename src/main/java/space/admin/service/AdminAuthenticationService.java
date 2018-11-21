package space.admin.service;

import java.util.List;

import space.admin.vo.AuthenticationVO;
import space.admin.vo.Page;
import space.po.Authentication;

public interface AdminAuthenticationService {

	/**
	 * 获取符合条件的记录总数
	 * 
	 * @param retrieval
	 *            模糊检索内容
	 * @param aType
	 *            认证账号的类型(学生1、老师2、社团3和学院4)
	 * @param type
	 *            检索类型(未处理0、已通过1、未通过2和全部检索3)
	 * @return
	 */
	int getTotalNumber(String retrieval, int aType, int type);

	/**
	 * 获取page当前页的记录
	 * 
	 * @param retrieval
	 *            模糊检索内容
	 * @param aType
	 *            认证账号的类型(学生1、老师2、社团3和学院4)
	 * @param type
	 *            检索类型(未处理0、已通过1、未通过2和全部检索3)
	 * @param page
	 *            分页相关信息类
	 * @return
	 */
	List<AuthenticationVO> get(String retrieval, int aType, int type, Page page);

	/**
	 * 更新认证记录
	 * 
	 * @param id
	 * @param type
	 *            0通过 1不通过
	 * @return 返回1成功
	 */
	int update(int id, int type);
	
	/**
	 * 
	* @Title: getAuthenticationByPrimaryKey 
	* @Description: TODO(根据authenticationId获取authentication) 
	* @param id
	* @return
	* @throws 
	* @date 2017年4月24日下午11:17:21	最近一次更新时间
	 */
	Authentication getAuthenticationByPrimaryKey (int id);
}
