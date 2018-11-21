package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.BuildingMapper;
import space.po.Building;
import space.service.BuildingService;

@Service("buildingService")
public class BuildingServiceImpl implements BuildingService{

	@Resource
	private BuildingMapper bm;

	@Override
	public List<Building> getBuildingByType(int type) {
		
		if(type != Building.CLASSBUILDING && type != Building.COMPLEXBUILDING && type != Building.LABBUILDING){
			return null;
		}
		
		List<Building> buildings = bm.selectByType(type);
		return buildings;
	}

	@Override
	public Building getBuildingById(int buiId) {
		
		return bm.selectByPrimaryKey(buiId);
	}
	
	
}
