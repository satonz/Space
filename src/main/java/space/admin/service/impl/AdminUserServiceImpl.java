package space.admin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminUserService;
import space.admin.vo.Page;
import space.admin.vo.UserVO;
import space.dao.AuthenticationMapper;
import space.dao.UserMapper;
import space.po.Authentication;
import space.po.User;

@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AuthenticationMapper authenticationMapper;

	@Override
	public int getTotalNumber(String retrieval, int type) {
		int result = 0;
		if (type == 0) {
			// 全部
			result = userMapper.countByRetrieval(retrieval);
		} else if (type != 5) {
			// 已认证
			result = authenticationMapper.countBy(retrieval, type, true, true);
		} else {
			// 未认证
		}
		return result;
	}

	@Override
	public List<UserVO> get(String retrieval, int type, Page page) {
		List<UserVO> list = new ArrayList<UserVO>();
		List<User> users = new ArrayList<User>();
		if (type == 0) {
			// 全部
			users = userMapper.selectBytRetrievalAndPage(retrieval, page);
		} else if (type != 5) {
			// 已认证
			List<Authentication> authentications = authenticationMapper.selectBy(retrieval, type, true, true, page);
			Iterator<Authentication> iterator = authentications.iterator();
			while (iterator.hasNext()) {
				users.add(iterator.next().getUser());
			}
		} else {
			// 未认证
		}
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			list.add(new UserVO(iterator.next()));
		}
		return list;
	}

}
