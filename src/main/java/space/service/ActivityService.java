package space.service;

import java.util.List;

import space.po.Activity;
import space.util.Page;

public interface ActivityService {

	List<Activity> getForeshowActs();

	List<Activity> getPassActsByPage(Page page);

	Activity selectById(int actId);
	
	int getPassActCount();

}
