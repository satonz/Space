package space.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminBuildingService;
import space.admin.vo.Page;
import space.dao.BuildingMapper;
import space.po.Building;

@Service("adminBuildingService")
@Transactional
public class AdminBuildingServiceImpl implements AdminBuildingService {

	@Autowired
	private BuildingMapper buildingMapper;

	@Override
	public int save(Building building) {
		int result = buildingMapper.selectByBuildingName(building.getBuiName());
		if (result == 0) {
			result = buildingMapper.insert(building);
		} else {
			// 建筑名称已经存在(不检查建筑类型)
			result = 0;
		}
		return result;
	}

	@Override
	public List<Building> get(int type) {
		return buildingMapper.selectByType(type);
	}

	@Override
	public int getTotalNumber(String retrieval, int type) {
		return buildingMapper.countByRetrievalAndType(retrieval, type);
	}

	@Override
	public List<Building> get(String retrieval, Page page, int type) {
		// TODO Auto-generated method stub
		return buildingMapper.selectByPageAndRetrieval(retrieval, type, page);
	}

	@Override
	public int delete(int buildingId) {
		return buildingMapper.deleteByPrimaryKey(buildingId);
	}
}
