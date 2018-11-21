package space.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import space.admin.service.AdminNoticeService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.Page;
import space.admin.vo.StatisticalInformation;
import space.po.Notice;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice")
public class NoticeController {

	@Autowired
	private AdminNoticeService adminNoticeService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 查看公告列表
	 * 
	 * @param retrieval
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage, Model model) {
		String dispatcher = "admin/notice";
		int totalNumber = adminNoticeService.totalNumber(retrieval);
		Page page = new Page(totalNumber, currentPage, 10);
		List<Notice> notices = adminNoticeService.getNotices(retrieval, page);

		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("notices", notices);
		model.addAttribute("page", page);
		model.addAttribute("retrieval", retrieval);

		return dispatcher;
	}

	/**
	 * 跳转到发布公告页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/toPulishPage")
	public String toPublishPage(Model model) {
		String dispatcher = "admin/notice-add";

		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		return dispatcher;
	}

	/**
	 * 发布公告
	 * 
	 * @param title
	 * @param content
	 * @param model
	 * @return
	 */
	@RequestMapping("/publish")
	public String publish(String title, String content, Model model) {
		String dispatcher = "redirect:list";
		Notice notice = new Notice();
		notice.setNoticeTitle(title);
		notice.setNoticeContent(content);
		int result = adminNoticeService.save(notice);
		if (result == 1) {
			model.addAttribute("tip", "发布公告成功");
		} else {
			model.addAttribute("tip", "发布公告失败");
			dispatcher = "redirect:toPulishPage";
		}

		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);

		return dispatcher;
	}

	/**
	 * 删除公告
	 * 
	 * @param noticeId
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		try {
			result = adminNoticeService.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (result == 1) {
			map.put("status", "TRUE");
		} else {
			map.put("status", "FALSE");
		}

		return map;
	}

}
