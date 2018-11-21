package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.SysinformMapper;
import space.po.Sysinform;
import space.po.User;
import space.service.SysinformService;

@Service("sysinformService")
public class SysinformServiceImpl implements SysinformService {

	@Resource
	private SysinformMapper sim;

	@Override
	public int getUnReadNumByUser(User user) {

		return sim.getUnReadNumByUser(user);
	}

	@Override
	public List<Sysinform> getAllByUser(User user) {
		// TODO Auto-generated method stub
		return sim.getAllByUser(user);
	}

	@Override
	public void updateAllToReaded(User user) {
		// TODO Auto-generated method stub
		sim.updateAllToReaded(user);
	}

}
