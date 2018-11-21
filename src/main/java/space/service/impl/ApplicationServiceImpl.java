package space.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.ApplicationMapper;
import space.po.Application;
import space.po.User;
import space.service.ApplicationService;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

	@Resource
	private ApplicationMapper am;

	@Override
	public int save(Application app) {
		// TODO Auto-generated method stub
		return am.insert(app);
	}

	@Override
	public List<Application> getAppByUser(User user) {
		// TODO Auto-generated method stub
		return am.selectByUserId(user.getUserId());
	}

	@Override
	public List<Application> checkTimeConflict(Application application) {
		// TODO Auto-generated method stub
		return am.checkTimeConflict(application);
	}

}
