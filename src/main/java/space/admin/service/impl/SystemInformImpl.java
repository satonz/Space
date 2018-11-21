package space.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import space.admin.service.AdminSystemInform;
import space.dao.SysinformMapper;
import space.po.Sysinform;

@Service("adminSystemInform")
public class SystemInformImpl implements AdminSystemInform {

	@Autowired
	private SysinformMapper sysinformMapper;
	
	@Override
	public int insertInform(Sysinform sysinform) {
		return sysinformMapper.insert(sysinform);
		
	}

}
