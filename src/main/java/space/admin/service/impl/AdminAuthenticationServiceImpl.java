package space.admin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminAuthenticationService;
import space.admin.vo.AuthenticationVO;
import space.admin.vo.Page;
import space.dao.AuthenticationMapper;
import space.po.Authentication;

@Service("adminAuthenticationService")
@Transactional
public class AdminAuthenticationServiceImpl implements AdminAuthenticationService {

	@Autowired
	private AuthenticationMapper authenticationMapper;

	@Override
	public int getTotalNumber(String retrieval, int aType, int type) {
		boolean status = false, deal = false;
		// 检索类型(未处理0、已通过1、未通过2和全部检索3)
		switch (type) {
		case 0:
			deal = false;
			break;
		case 1:
			status = true;
			deal = true;
			break;
		case 2:
			status = false;
			deal = true;
			break;

		default:
			break;
		}
		return authenticationMapper.countBy(retrieval, aType, status, deal);
	}

	@Override
	public List<AuthenticationVO> get(String retrieval, int aType, int type, Page page) {
		boolean status = false, deal = false;
		// 检索类型(未处理0、已通过1、未通过2和全部检索3)
		switch (type) {
		case 0:
			deal = false;
			break;
		case 1:
			status = true;
			deal = true;
			break;
		case 2:
			status = false;
			deal = true;
			break;

		default:
			break;
		}
		List<Authentication> authentications = authenticationMapper.selectBy(retrieval, aType, status, deal, page);
		List<AuthenticationVO> list = new ArrayList<AuthenticationVO>();
		Iterator<Authentication> iterator = authentications.iterator();
		while (iterator.hasNext()) {
			Authentication authentication = iterator.next();
			list.add(new AuthenticationVO(authentication));
		}
		return list;
	}

	@Override
	public int update(int id, int type) {
		Authentication authentication = authenticationMapper.selectByPrimaryKey(id);
		authentication.setInfIsDealed(true);
		if (type == 0) {
			// 通过
			authentication.setInfStatus(true);
		} else {
			authentication.setInfStatus(false);
		}
		return authenticationMapper.updateByPrimaryKeySelective(authentication);
	}

	@Override
	public Authentication getAuthenticationByPrimaryKey(int id) {
		return authenticationMapper.selectByPrimaryKey(id);
	}

}
