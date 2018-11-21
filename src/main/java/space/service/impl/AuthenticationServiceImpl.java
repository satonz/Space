package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.AuthenticationMapper;
import space.po.Authentication;
import space.po.User;
import space.service.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource
	private AuthenticationMapper am;

	@Override
	public Authentication save(Authentication authentication) {
		int infId = am.insert(authentication);		
		return authentication;
	}
	
	//返回用户的认证
	@Override
	public Authentication selectByUser(User user) {
		if(user == null){
			return null;
		}
		List<Authentication> auths = am.selectByUserId(user.getUserId());
		if(auths.size()==0){
			return null;
		}
		return auths.get(0);
	}

	@Override
	public int delete(Authentication authentication) {
		
		return am.deleteByPrimaryKey(authentication.getInfId());
	}

}
