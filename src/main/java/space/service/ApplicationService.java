package space.service;

import java.util.Date;
import java.util.List;

import space.po.Application;
import space.po.User;

public interface ApplicationService {

	int save(Application app);

	List<Application> getAppByUser(User loginUser);

	List<Application> checkTimeConflict(Application application);

}
