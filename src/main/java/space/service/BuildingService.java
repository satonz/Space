package space.service;

import java.util.List;

import space.po.Building;

public interface BuildingService {

	List<Building> getBuildingByType(int type);
	
	Building getBuildingById(int buiId);
	
}
