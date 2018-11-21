package space.service;

import java.util.List;

import space.po.Comminform;
import space.po.User;

public interface ComminformService {

	int getUnReadNumByUser(User user);

	List<Comminform> getAllByUser(User user);
	
	int save(Comminform commInf);

	void updateAllToReaded(User user);
}
