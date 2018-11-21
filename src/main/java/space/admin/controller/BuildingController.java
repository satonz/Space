package space.admin.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import space.admin.service.AdminBuildingService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.Page;
import space.admin.vo.StatisticalInformation;
import space.po.Building;

@Controller("adminBuildingController")
@RequestMapping("/admin/building")
public class BuildingController {

	@Autowired
	private AdminBuildingService adminBuildingService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 获取建筑列表
	 * 
	 * @param retrieval
	 * @param currentPage
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage,
			@RequestParam(name = "type", defaultValue = "0") int type, Model model) {
		String dispatcher = "admin/building";
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		// 2.获取page
		int totalNumber = adminBuildingService.getTotalNumber(retrieval, type);
		Page page = new Page(totalNumber, currentPage, 9);
		// 3.获取List<building>
		List<Building> list = adminBuildingService.get(retrieval, page, type);

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("page", page);
		model.addAttribute("retrieval", retrieval);
		model.addAttribute("type", type);
		model.addAttribute("list", list);
		return dispatcher;
	}

	@RequestMapping("/toAddBuilding")
	public String toAddBuildingPage(int type, Model model) {
		String dispatcher = "admin/building-add";
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("type", type);
		return dispatcher;
	}

	@RequestMapping("/save")
	public String save(String name, String introduce, int type, Model model) {
		Building building = new Building(name, (byte) type, introduce);
		int result = adminBuildingService.save(building);
		if (result == 1) {
			model.addAttribute("tip", "添加建筑成功!");
		} else if (result == 0) {
			model.addAttribute("tip", "添加建筑失败，已存在相同的建筑名称!");
			model.addAttribute("name", name);
			model.addAttribute("introduce", introduce);
		}
		return "admin/building-add";
	}

	@RequestMapping("/getBuildingsByType")
	@ResponseBody
	public List<Building> getBuildingsByType(int type) {
		List<Building> list = new ArrayList<Building>();

		Iterator<Building> iterator = adminBuildingService.get(type).iterator();
		while (iterator.hasNext()) {
			Building building = new Building();
			Building next = iterator.next();
			building.setBuiId(next.getBuiId());
			building.setBuiName(next.getBuiName());
			list.add(building);
		}
		return list;
	}

	@RequestMapping("/delete")
	public String delete(int buildingId) {
		String dispatcher = "redirect:list";
		adminBuildingService.delete(buildingId);
		return dispatcher;
	}

}
