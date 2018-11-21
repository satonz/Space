package space.admin.service;

import java.util.List;

import space.admin.vo.ActivityInformation;
import space.admin.vo.ActivityVO;
import space.admin.vo.Page;
import space.po.Activity;

/**
 * 与活动相关的业务类
 *
 */
public interface AdminActivityService {

	/**
	 * 发布活动
	 * 
	 * @param activityInformation
	 * @return 1 成功
	 */
	int save(ActivityInformation activityInformation);

	/**
	 * 获取满足条件的总数量
	 * 
	 * @param retrieval
	 * @return
	 */
	int getTotalNumber(String retrieval);

	/**
	 * 获取List<ActivityVO>
	 * 
	 * @param retrieval
	 * @param page
	 * @return
	 */
	List<ActivityVO> get(String retrieval, Page page);

	/**
	 * 获取ActivityVO
	 * 
	 * @param activityId
	 * @return
	 */
	Activity get(int activityId);

	/**
	 * 删除activityId的记录
	 * 
	 * @param activityId
	 * @return
	 */
	int delete(int activityId);

}
