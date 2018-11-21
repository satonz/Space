package space.admin.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminActivityService;
import space.admin.vo.ActivityInformation;
import space.admin.vo.ActivityVO;
import space.admin.vo.Page;
import space.dao.ActivityMapper;
import space.dao.RoomMapper;
import space.po.Activity;
import space.po.Room;

@Service("adminActivityService")
@Transactional
public class AdminActivityServiceImpl implements AdminActivityService {

	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private ActivityMapper activityMapper;

	@Override
	public int save(ActivityInformation activityInformation) {
		Room room = roomMapper.selectByPrimaryKey(activityInformation.getRoomId());
		Activity activity = null;
		int result = 0;
		try {
			activity = new Activity(activityInformation);
			activity.setRoom(room);
			result = activityMapper.insert(activity);
		} catch (ParseException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int getTotalNumber(String retrieval) {
		return activityMapper.count(retrieval);
	}

	@Override
	public List<ActivityVO> get(String retrieval, Page page) {
		List<Activity> activities = activityMapper.selectBy(retrieval, page);
		List<ActivityVO> list = new ArrayList<ActivityVO>();
		Iterator<Activity> iterator = activities.iterator();
		while (iterator.hasNext()) {
			list.add(new ActivityVO(iterator.next()));
		}
		return list;
	}

	@Override
	public Activity get(int activityId) {
		return activityMapper.selectByPrimaryKey(activityId);
	}

	@Override
	public int delete(int activityId) {
		return activityMapper.deleteByPrimaryKey(activityId);
	}

}
