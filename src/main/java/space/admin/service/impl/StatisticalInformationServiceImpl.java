package space.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.StatisticalInforService;
import space.admin.vo.StatisticalInformation;
import space.dao.ActionMapper;
import space.dao.ApplicationMapper;
import space.dao.AuthenticationMapper;
import space.po.Authentication;

@Service("statisticlaInformationService")
@Transactional
public class StatisticalInformationServiceImpl implements StatisticalInforService {

	@Autowired
	private AuthenticationMapper authenticationMapper;
	@Autowired
	private ApplicationMapper applicationMapper;
	@Autowired
	private ActionMapper actionMapper;

	@Override
	public StatisticalInformation get() {
		int studentAuth = authenticationMapper.countBy("", Authentication.INF_CLASS, true, false);
		int teacherAuth = authenticationMapper.countBy("", Authentication.INF_TEACHER, true, false);
		int clubAuth = authenticationMapper.countBy("", Authentication.INF_ASSOCIATION, true, false);
		int colleageAuth = authenticationMapper.countBy("", Authentication.INF_INSTITUTE, true, false);

		System.out.println("---------------------------");
		System.out.println("student:" + studentAuth + ", teacher:" + teacherAuth + ", club:" + clubAuth + ", colleage:"
				+ colleageAuth);
		System.out.println("---------------------------");

		int classRoomApplications = applicationMapper.countByBuildingTypeStatusDealRetrieval(0, true, false, "");
		int labApplications = applicationMapper.countByBuildingTypeStatusDealRetrieval(1, true, false, "");
		int complexBuildingApplications = applicationMapper.countByBuildingTypeStatusDealRetrieval(2, true, false, "");

		int historyVisitors = actionMapper.countAll();
		int todayVisitors = actionMapper.countToday();

		StatisticalInformation statisticalInformation = new StatisticalInformation(studentAuth, teacherAuth, clubAuth,
				colleageAuth, classRoomApplications, labApplications, complexBuildingApplications, 0, historyVisitors,
				todayVisitors);

		return statisticalInformation;
	}

}
