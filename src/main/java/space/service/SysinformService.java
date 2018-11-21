package space.service;

import java.util.List;

import space.po.Sysinform;
import space.po.User;

public interface SysinformService {

	int getUnReadNumByUser(User user);

	List<Sysinform> getAllByUser(User user);

	void updateAllToReaded(User loginUser);

}
