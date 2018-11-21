package space.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.ActionMapper;
import space.po.Action;
import space.service.ActionService;

@Service("actionService")
public class ActionServiceImpl implements ActionService {

	@Resource
	private ActionMapper am;

	@Override
	public int save(Action action) {
		// TODO Auto-generated method stub
		return am.insert(action);
	}

}
