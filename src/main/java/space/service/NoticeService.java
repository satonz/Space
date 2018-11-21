package space.service;

import java.util.List;

import space.po.Notice;
import space.util.Page;

public interface NoticeService {

	List<Notice> getNoticesByPage(Page page);
	
	int getCount();
}
