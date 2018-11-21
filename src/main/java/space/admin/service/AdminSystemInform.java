package space.admin.service;

import space.po.Sysinform;

/**
 * 
 * Title: 系统通知业务
 * Description: 
 * @date 2017年4月24日下午12:31:56
 */
public interface AdminSystemInform {

	/**
	 * 
	* @Title: insertInform 
	* @Description: TODO(发布通知) 
	* @param sysinform
	* @return 1成功
	* @throws 
	* @date 2017年4月24日下午12:36:06	最近一次更新时间
	 */
	int insertInform(Sysinform sysinform);
	
}
