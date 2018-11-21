package space.admin.service;

import java.util.List;

import space.admin.vo.ApplicationVO;
import space.admin.vo.Page;
import space.po.Application;
import space.po.User;

public interface AdminApplicationService {

	/**
	 * 获取搜索条件满足的总记录数
	 * 
	 * @param retrieval
	 *            检索内容
	 * @param type
	 *            处理类型 0 未处理， 1 通过， 2不通过
	 * @return
	 */
	int getTotalNumber(String retrieval, int type);

	/**
	 * 获取满足条件的场地申请，并转化为VO
	 * 
	 * @param buidingType
	 * @param retrieval
	 * @param type
	 * @param page
	 * @return
	 */
	List<ApplicationVO> get(int buidingType, String retrieval, int type, Page page);

	/**
	 * 
	 * @param applicationId
	 * @param status
	 *            0 通过申请, 1不通过申请
	 * @return 1成功 0该房间已在该时间段被申请使用
	 */
	int update(int applicationId, int status);
	
	/**
	 * 
	* @Title: getUserByApplicationId 
	* @Description: TODO(通过applicationId获取user) 
	* @param applicationId
	* @return
	* @throws 
	* @date 2017年4月24日下午12:43:38	最近一次更新时间
	 */
	User getUserByApplicationId(int applicationId);
	
	/**
	 * 
	* @Title: getApplicationByPrimaryKey 
	* @Description: TODO(通过applicationId获取user) 
	* @param id
	* @return
	* @throws 
	* @date 2017年4月24日下午11:07:57	最近一次更新时间
	 */
	Application getApplicationByPrimaryKey(int id);
}
