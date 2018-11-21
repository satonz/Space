package space.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import space.admin.service.AdminApplicationService;
import space.admin.service.StatisticalInforService;
import space.admin.service.AdminSystemInform;
import space.admin.vo.ApplicationVO;
import space.admin.vo.Page;
import space.admin.vo.StatisticalInformation;
import space.po.Application;
import space.po.Building;
import space.po.Room;
import space.po.Sysinform;
import space.po.User;

@Controller("adminApplicationController")
@RequestMapping("/admin/application")
public class ApplicationController {

	@Autowired
	private AdminApplicationService adminApplicationService;
	@Autowired
	private StatisticalInforService statisticalInforService;
	@Autowired
	private AdminSystemInform adminSystemInform;
	

	/**
	 * 
	 * @param type
	 *            处理类型 0 未处理， 1 通过， 2不通过
	 * @param retrieval
	 *            检索内容
	 * @param currentPage
	 *            当前页
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "buildingType", defaultValue = "0") int buildingType,
			@RequestParam(name = "type", defaultValue = "0") int type,
			@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage, Model model) {
		String dispatcher = "admin/application";
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		// 2.获取page
		int totalNumber = adminApplicationService.getTotalNumber(retrieval, type);
		Page page = new Page(totalNumber, currentPage, 10);
		// 3.获取List<ApplicationVO>
		List<ApplicationVO> list = adminApplicationService.get(buildingType, retrieval, type, page);

		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("buildingType", buildingType);
		model.addAttribute("type", type);
		model.addAttribute("retrieval", retrieval);

		return dispatcher;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(处理场地申请请求)
	 * @param id
	 * @param status
	 *            0通过 1不通过
	 * @return
	 * @throws @date
	 *             2017年4月23日下午2:16:01 最近一次更新时间
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<Object, Object> update(int id, String content, int status) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		int result = 0;
		try {
			Sysinform sysinform = new Sysinform();
			sysinform.setReaded(false);
			sysinform.setSysinformTime(new Date());
			Application application = adminApplicationService.getApplicationByPrimaryKey(id);
			Room room = application.getRoom();
			Building building = room.getBuilding();
			String buidingType = building.getBuiType() == Building.CLASSBUILDING ? "教学楼" : (building.getBuiType() == Building.LABBUILDING ? "实验楼" : "综合楼");
			
			User user = adminApplicationService.getUserByApplicationId(id);
			sysinform.setUser(user);
			//通过申请
			if (status == 0) {
				result = adminApplicationService.update(id, status);
				if (result == 1) {
					sysinform.setSysinformInfo("你申请的" + buidingType + building.getBuiName() + ", 场地" + room.getRoomNumber() +  "已通过!");
					adminSystemInform.insertInform(sysinform);
				}
			} else if (status == 1) {
				result = adminApplicationService.update(id, status);
				if (result == 1) {
					sysinform.setSysinformInfo("你申请的" + buidingType + building.getBuiName() + ", 场地" + room.getRoomNumber() +  "已被拒绝，原因是：" + content);
					adminSystemInform.insertInform(sysinform);
				}
			} 
			
			
		} catch (Exception e) {
		}

		if (result == 1) {
			map.put("status", "TRUE");
		} else {
			map.put("status", "FALSE");
			map.put("tip", "该时间段该房间已被申请使用");
		}
		return map;
	}
}
