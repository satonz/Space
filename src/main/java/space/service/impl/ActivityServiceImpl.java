package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.ActivityMapper;
import space.po.Activity;
import space.service.ActivityService;
import space.util.Page;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityMapper actMapper;

	/*
	 * 预告的活动和正在进行的活动，在首页轮播
	 */
	@Override
	public List<Activity> getForeshowActs() {
		return actMapper.selectForeshowActs();
	}

	/*
	 * 往期活动，要分页
	 */
	@Override
	public List<Activity> getPassActsByPage(Page page) {
		return actMapper.getPassActsByPage(page);
	}

	@Override
	public Activity selectById(int actId) {
		return actMapper.selectByPrimaryKey(actId);
	}

	@Override
	public int getPassActCount() {
		return actMapper.getPassActCount();
	}

}
