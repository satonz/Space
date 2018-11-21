package space.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.ProfileMapper;
import space.po.Profile;
import space.po.User;
import space.service.ProfileService;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

	@Resource
	private ProfileMapper pm;

	@Override
	public int save(Profile profile) {
		// TODO Auto-generated method stub
		return pm.insert(profile);
	}

	@Override
	public Profile selectByUser(User user) {
		// TODO Auto-generated method stub
		return pm.selectByUserId(user.getUserId());
	}

	@Override
	public int update(Profile profile) {
		// TODO Auto-generated method stub
		return pm.updateByPrimaryKey(profile);
	}

}
