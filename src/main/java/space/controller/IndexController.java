package space.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import space.po.Activity;
import space.po.Notice;
import space.service.ActivityService;
import space.service.NoticeService;
import space.util.Page;

/*
 * 系统主页的Controller
 */
@Controller
@RequestMapping(value= {"/index","/"})
public class IndexController {

	@Autowired
	private ActivityService activityService;

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("")
	public ModelAndView index(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		// 获取预告和正在进行的活动
		List<Activity> foreshowActs = activityService.getForeshowActs();
		//将当前活动的第一条记录的ID放入session  方便页面当前活动调用
		if((foreshowActs.size())!=0)
		{
			Integer s=foreshowActs.get(0).getActId();
			session.setAttribute("list", s);
		}
		// 往期活动，分页
		Page indexActPage = (Page) session.getAttribute("indexActPage");
		if (indexActPage == null) {
			int actNum = activityService.getPassActCount();
			int pageSize = 6;
			indexActPage = new Page();
			indexActPage.count(actNum, pageSize, 6);
		} else {
			indexActPage.count(indexActPage.getTotalNumber(), indexActPage.getPageSize(), 6);
		}
		//获取往期活动
		List<Activity> passActs = activityService.getPassActsByPage(indexActPage);
		session.setAttribute("indexActPage", indexActPage);

		Page noticePage = (Page) session.getAttribute("noticePage");
		if (noticePage == null) {
			noticePage = new Page();
			int noticeCount = noticeService.getCount();
			int pageSize = 5;
			noticePage.count(noticeCount, pageSize, 1);
		} else {
			noticePage.count(noticePage.getTotalNumber(), noticePage.getPageSize(), 1);
		}
		session.setAttribute("noticePage", noticePage);
		//获取第一页的公告
		List<Notice> notices = noticeService.getNoticesByPage(noticePage);
		mv.addObject("foreshowActs", foreshowActs);
		mv.addObject("passActs", passActs);
		mv.addObject("notices", notices);
		mv.setViewName("jsp/index");
		return mv;
	}

	/*
	 * 分页获取公告，每次请求则页数加1
	 */
	@RequestMapping("/notice/")
	@ResponseBody
	public List<Notice> notice(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Page noticePage = (Page) session.getAttribute("noticePage");
		if (noticePage == null) {

			return null;
		} else {
			int nextPage = noticePage.getCurrentPage() + 1;
			if (nextPage > noticePage.getTotalPage()) {

				return null;
			}

			noticePage.count(noticePage.getTotalNumber(), noticePage.getPageSize(), nextPage);
			session.setAttribute("noticePage", noticePage);
		}

		List<Notice> notices = noticeService.getNoticesByPage(noticePage);
		return notices;
	}
}
