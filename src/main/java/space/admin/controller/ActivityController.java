package space.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import space.admin.service.AdminActivityService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.ActivityInformation;
import space.admin.vo.ActivityVO;
import space.admin.vo.Page;
import space.admin.vo.StatisticalInformation;
import space.po.Activity;
import space.po.Building;
import space.po.Room;
import space.po.Ticket;

@Controller("adminActivityController")
@RequestMapping("/admin/activity")
public class ActivityController {

	@Autowired
	private AdminActivityService adminActivityService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 跳转到填写发布活动信息页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddActivityPage")
	public String toAddActivityPage(Model model) {
		String dispatcher = "admin/activity-add";
		StatisticalInformation statisticalInformation = statisticalInforService.get();

		model.addAttribute("statisticalInformation", statisticalInformation);
		return dispatcher;
	}

	/**
	 * 发布活动
	 * 
	 * @param activityInformation
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public List<String> save(@RequestBody ActivityInformation activityInformation, Model model) {
		List<String> list = new ArrayList<String>();
		activityInformation.setStartTime(activityInformation.getStartTime().replace("T", " "));
		activityInformation.setEndTime(activityInformation.getEndTime().replace("T", " "));
		String imgPath = activityInformation.getImgPath();
		String[] split = imgPath.split("/");
		
		activityInformation.setImgPath("/admin/file/upload/image/" + split[split.length - 1] );
		int result = adminActivityService.save(activityInformation);
		if (result == 1) {
			list.add(0, "TRUE");
		} else {
			list.add(0, "FALSE");
		}

		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);

		return list;
	}

	/**
	 * 查看活动列表
	 * 
	 * @param retrieval
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage, Model model) {
		String dispatcher = "admin/activity";
		// 1.获取统计信息
		// 2.获取page
		int totalNumber = adminActivityService.getTotalNumber(retrieval);
		Page page = new Page(totalNumber, currentPage, 10);
		// 3.获取List<ActivityVO>
		List<ActivityVO> list = adminActivityService.get(retrieval, page);

		StatisticalInformation statisticalInformation = statisticalInforService.get();

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("retrieval", retrieval);

		return dispatcher;
	}

	/**
	 * 删除活动
	 * 
	 * @param id
	 * @param retrieval
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, String> delete(int id) {

		Map<String, String> map = new HashMap<String, String>();
		int result = 0;
		try {
			result = adminActivityService.delete(id);
		} catch (Exception e) {
		}
		if (result == 1) {
			// 删除成功
			map.put("status", "TRUE");
		} else {
			map.put("status", "FALSE");
		}

		return map;
	}

	/**
	 * 查看活动详情
	 * 
	 * @param activityId
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(int activityId, Model model) {
		String dispatcher = "admin/activity-detail";

		// 1.获取统计信息
		// 2.获取ActivityVo
		Activity activity = adminActivityService.get(activityId);
		Room room = activity.getRoom();
		Building building = room.getBuilding();
		String buidingType = building.getBuiType() == 0 ? "教学楼" : (building.getBuiId() == 1 ? "实验楼" : "综合楼");
		String space = buidingType + "、" + building.getBuiName() + "、" + room.getRoomNumber();

		StatisticalInformation statisticalInformation = statisticalInforService.get();
		
		//获取持票人相关信息
		List<Ticket> tickets = activity.getTickets();

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("activity", activity);
		model.addAttribute("space", space);
		model.addAttribute("tickets", tickets);

		return dispatcher;
	}

}
