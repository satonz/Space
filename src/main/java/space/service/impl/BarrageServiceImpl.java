package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.BarrageMapper;
import space.po.Activity;
import space.po.Barrage;
import space.service.BarrageService;

@Service("barrageService")
public class BarrageServiceImpl implements BarrageService{

	@Resource 
	private BarrageMapper bm;

	@Override
	public int save(Barrage barrage) {
		// TODO Auto-generated method stub
		return bm.insert(barrage);
	}

	@Override
	public List<Barrage> getLastNByAct(Activity act, int n) {
		
		return bm.getLastNByAct(act,n);
	}

	@Override
	public List<Barrage> getActRealTimeBass(Activity act, int maxId) {
		// TODO Auto-generated method stub
		return bm.getActRealTimeBass(act,maxId);
	}

}
