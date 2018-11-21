package space.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminNoticeService;
import space.admin.vo.Page;
import space.dao.NoticeMapper;
import space.po.Notice;

@Service("adminNoticeService")
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public int save(Notice notice) {
		return noticeMapper.insert(notice);
	}

	@Override
	public int totalNumber(String retrieval) {
		return noticeMapper.selectByRetrieval("%" + retrieval + "%");
	}

	@Override
	public List<Notice> getNotices(String retrieval, Page page) {
		return noticeMapper.selectByRetrievalAndPage("%" + retrieval + "%", page);
	}

	@Override
	public int delete(int noticeId) {
		return noticeMapper.deleteByPrimaryKey(noticeId);
	}

}
