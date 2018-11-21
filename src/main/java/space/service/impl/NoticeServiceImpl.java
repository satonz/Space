package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.NoticeMapper;
import space.po.Notice;
import space.service.NoticeService;
import space.util.Page;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private NoticeMapper nm;
	
	@Override
	public List<Notice> getNoticesByPage(Page page) {
		return nm.selectByPage(page);
	}

	@Override
	public int getCount() {
		return nm.getCount();
	}
}
