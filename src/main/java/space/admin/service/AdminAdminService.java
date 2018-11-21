package space.admin.service;

import java.util.List;

import space.admin.vo.ApplicationVO;
import space.po.Admin;

/**
 * 与管理员账号及后台首页相关的业务类
 *
 */
public interface AdminAdminService {
	/**
	 * 后台登录，登录成功返回一个不含密码字段的admin实例，否则返回null
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	Admin login(String email, String password);

	/**
	 * 更新密码
	 * 
	 * @param userId
	 *            用户id
	 * @param oldPwd
	 *            旧密码
	 * @param newPwd
	 *            新密码
	 * @return 修改成功返回1
	 */
	int updatePwd(int userId, String oldPwd, String newPwd);

	/**
	 * 获取未来第n天场地使用信息(n>=0)
	 * 
	 * @return
	 */
	List<ApplicationVO> getApplicationsIntNDays(int n);
	
	/**
	 * 
	* @Title: save 
	* @Description: TODO(保存一个admin记录) 
	* @param admin
	* @return 操作数据库记录数
	* @throws 
	* @date 2017年4月27日下午3:35:25	最近一次更新时间
	 */
	int save (Admin admin);
}
