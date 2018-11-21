package space.service;

import java.util.List;

import space.po.Activity;
import space.po.Barrage;

public interface BarrageService {

	int save(Barrage barrage);

	List<Barrage> getLastNByAct(Activity act, int n);

	List<Barrage> getActRealTimeBass(Activity act, int maxId);
}
