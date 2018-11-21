package space.admin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminAdminService;
import space.admin.vo.ApplicationVO;
import space.dao.AdminMapper;
import space.dao.ApplicationMapper;
import space.po.Admin;
import space.po.Application;

@Service("adminAdminService")
@Transactional
public class AdminAdminServiceImpl implements AdminAdminService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private ApplicationMapper applicationMapper;

	@Override
	public Admin login(String email, String password) {
		return adminMapper.selectByEmailAndPassword(email, password);
	}

	@Override
	public int updatePwd(int userId, String oldPwd, String newPwd) {
		int result = 0;
		Admin admin = adminMapper.selectByPrimaryKey(userId);
		if (admin.getPassword().equals(oldPwd)) {
			admin.setPassword(newPwd);
			result = adminMapper.updateByPrimaryKey(admin);
		}
		return result;
	}

	@Override
	public List<ApplicationVO> getApplicationsIntNDays(int n) {
		List<Application> applications = applicationMapper.selectApplicationsIntNDays(n, true, true);
		List<ApplicationVO> applicationVOs = new ArrayList<ApplicationVO>();
		Iterator<Application> iterator = applications.iterator();
		while (iterator.hasNext()) {
			applicationVOs.add(new ApplicationVO(iterator.next()));
		}
		return applicationVOs;
	}

	@Override
	public int save(Admin admin) {
		return adminMapper.insert(admin);
	}

}
