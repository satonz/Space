package space.admin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminApplicationService;
import space.admin.vo.ApplicationVO;
import space.admin.vo.Page;
import space.dao.ApplicationMapper;
import space.po.Application;
import space.po.User;

@Service("adminApplicationService")
@Transactional
public class AdminApplicationServiceImpl implements AdminApplicationService {

	@Autowired
	private ApplicationMapper applicationMapper;

	@Override
	public int getTotalNumber(String retrieval, int type) {
		boolean status = false, deal = false;
		switch (type) {
		case 0:
			// 未处理
			break;
		case 1:
			// 已通过
			deal = true;
			status = true;
			break;
		case 2:
			deal = true;
			status = false;
			break;

		default:
			break;
		}

		return applicationMapper.count(retrieval, status, deal);
	}

	@Override
	public List<ApplicationVO> get(int buildingType, String retrieval, int type, Page page) {
		boolean status = false, deal = false;
		switch (type) {
		case 0:
			// 未处理
			break;
		case 1:
			// 已通过
			deal = true;
			status = true;
			break;
		case 2:
			deal = true;
			status = false;
			break;

		default:
			break;
		}
		List<Application> applications = applicationMapper.selectBy(buildingType, retrieval, status, deal, page);
		List<ApplicationVO> list = new ArrayList<ApplicationVO>();
		Iterator<Application> iterator = applications.iterator();
		while (iterator.hasNext()) {
			list.add(new ApplicationVO(iterator.next()));
		}
		return list;
	}

	@Override
	public int update(int applicationId, int status) {
		Application application = applicationMapper.selectByPrimaryKey(applicationId);
		int result = 0;
		if (status == 0) {
			// 进行冲突检测
			result = applicationMapper.countByRoomIdAndAppUserTime(application.getRoom().getRoomId(),
					application.getAppStartTime(), application.getAppEndTime());
			if (result >= 1) {
				result = 0;
			} else {
				application.setAppStatus(true);
				application.setAppIsDealed(true);
				result = applicationMapper.updateByPrimaryKey(application);
			}
		} else {
			application.setAppStatus(false);
			application.setAppIsDealed(true);
			result = applicationMapper.updateByPrimaryKey(application);
		}

		return result;

	}

	@Override
	public User getUserByApplicationId(int applicationId) {
		Application application = applicationMapper.selectByPrimaryKey(applicationId);
		return application.getUser();
	}

	@Override
	public Application getApplicationByPrimaryKey(int id) {
		return applicationMapper.selectByPrimaryKey(id);
	}

}
