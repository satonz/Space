package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.ComminformMapper;
import space.po.Comminform;
import space.po.User;
import space.service.ComminformService;

@Service("comminformService")
public class ComminformServiceImpl implements ComminformService {

	@Resource
	private ComminformMapper cim;

	@Override
	public int getUnReadNumByUser(User user) {

		return cim.getUnReadNumByUser(user);
	}

	@Override
	public List<Comminform> getAllByUser(User user) {
		// TODO Auto-generated method stub
		return cim.getAllByUser(user);
	}

	@Override
	public int save(Comminform commInf) {
		// TODO Auto-generated method stub
		return cim.insert(commInf);
	}

	@Override
	public void updateAllToReaded(User user) {
		cim.updateAllToReaded(user);
	}

}
