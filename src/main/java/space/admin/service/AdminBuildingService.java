package space.admin.service;

import java.util.List;

import space.admin.vo.Page;
import space.po.Building;

/**
 * 与建筑相关的业务类
 *
 */
public interface AdminBuildingService {

	/**
	 * 添加建筑
	 * 
	 * @param building
	 * @return 1 成功， 0已存在相同名称的建筑
	 */
	int save(Building building);

	/**
	 * 获取满足条件的记录总数
	 * 
	 * @param retrieval
	 * @param type
	 * @return
	 */
	int getTotalNumber(String retrieval, int type);

	/**
	 * 获取满足条件的建筑列表
	 * 
	 * @param retrieval
	 * @param page
	 * @param type
	 * @return
	 */
	List<Building> get(String retrieval, Page page, int type);

	/**
	 * 获取满足条件的建筑列表
	 * 
	 * @param type
	 * @return
	 */
	List<Building> get(int type);

	/**
	 * 删除buildingid的记录
	 * 
	 * @param buildingId
	 * @return
	 */
	int delete(int buildingId);

}
