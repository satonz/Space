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

import space.admin.service.AdminReplyService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.Page;
import space.admin.vo.ReplyVO;
import space.admin.vo.StatisticalInformation;

@Controller("adminReplyController")
@RequestMapping("/admin/reply")
public class ReplyController {

	@Autowired
	private AdminReplyService adminReplyService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 查看二级评论列表
	 * 
	 * @param retrieval
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage, Model model) {
		String dispatcher = "admin/reply";
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		// 2.获取page
		int totalNumber = adminReplyService.getTotalNumber(retrieval);
		Page page = new Page(totalNumber, currentPage, 20);
		// 3.获取List<ActivityVO>
		List<ReplyVO> list = adminReplyService.get(retrieval, page);

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("retrieval", retrieval);

		return dispatcher;
	}

	/**
	 * 删除评论记录id为Id的记录
	 * 
	 * @param retrieval
	 * @param currentPage
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(int id) {

		Map<String, Object> map = new HashMap<String, Object>();

		int result = 0;
		try {
			result = adminReplyService.delete(id);
		} catch (Exception e) {
		}
		if (result == 1) {
			// 删除成功
			map.put("status", "TRUE");
		} else {
			// 删除失败
			map.put("status", "FALSE");
		}

		return map;
	}

}
