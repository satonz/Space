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

import space.admin.service.AdminRoomService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.Page;
import space.admin.vo.RoomVO;
import space.admin.vo.StatisticalInformation;
import space.po.Building;
import space.po.Room;

@Controller("adminRoomController")
@RequestMapping("/admin/room")
public class RoomController {

	@Autowired
	private AdminRoomService adminRoomService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 获取场地列表
	 * 
	 * @param retrieval
	 * @param currentPage
	 * @param buildingId
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage,
			@RequestParam(name = "buildingId") int buildingId, Model model) {
		String dispatcher = "admin/room";

		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		// 2.获取Page
		int totalNumber = adminRoomService.getTotalNumber(retrieval, buildingId);
		Page page = new Page(totalNumber, currentPage, 10);
		// 3.获取List<Room>
		List<Room> list = adminRoomService.get(retrieval, buildingId, page);
		// 4.获取建筑类型
		String buildingType = null, buildingName = null;
		if (list.size() >= 1) {
			Building building = list.get(0).getBuilding();
			buildingType = building.getBuiType() == 0 ? "教学楼" : (building.getBuiId() == 1 ? "实验楼" : "综合楼");
			buildingName = building.getBuiName();
		}

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("page", page);
		model.addAttribute("retrieval", retrieval);
		model.addAttribute("buildingId", buildingId);
		model.addAttribute("list", list);

		model.addAttribute("buildingType", buildingType);
		model.addAttribute("buildingName", buildingName);

		return dispatcher;
	}

	/**
	 * 跳转到添加房间页面
	 * 
	 * @param buildingId
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddRoomPage")
	public String toAddRoomPage(int buildingId, Model model) {
		String dispatcher = "admin/room-add";
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("buildingId", buildingId);
		return dispatcher;
	}

	/**
	 * 添加一个房间
	 * 
	 * @param buildingId
	 * @param number
	 * @param capacity
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(int buildingId, int number, int capacity, Model model) {
		String dispatcher = "admin/room-add";
		Room room = new Room();
		room.setRoomCapacity(capacity);
		room.setRoomNumber(number);

		int result = adminRoomService.save(room, buildingId);
		if (result == 1) {
			model.addAttribute("tip", "新增成功");
		} else {
			model.addAttribute("tip", "新增失败");
		}
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("buildingId", buildingId);
		return dispatcher;
	}

	/**
	 * 删除房间
	 * 
	 * @param retrieval
	 * @param currentPage
	 * @param buildingId
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String retrieval, int page, int buildingId, int roomId, Model model) {
		String dispatcher = "redirect:list?buildingId=" + buildingId + "&retrieval=" + retrieval + "&page" + page;
		int result = adminRoomService.delete(roomId);
		if (result == 1) {
			// 删除成功
			model.addAttribute("tip", "删除成功");
		} else {
			// 删除失败
			model.addAttribute("tip", "删除失败");
		}

		model.addAttribute("retrieval", retrieval);
		model.addAttribute("page", page);
		model.addAttribute("buildingId", buildingId);

		return dispatcher;
	}

	/**
	 * 跳转到更新房间信息页面
	 * 
	 * @param roomId
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditPage")
	public String toEditRoomPage(int roomId, Model model) {
		String dispatcher = "admin/room-edit";
		Room room = adminRoomService.get(roomId);
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("room", room);
		model.addAttribute("building", room.getBuilding());
		return dispatcher;
	}

	/**
	 * 更新房间
	 * 
	 * @param roomId
	 * @param number
	 * @param capacity
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	public String update(int roomId, int number, int capacity, Model model) {
		String dispatcher = "admin/room-edit";

		Room room = new Room();
		room.setRoomId(roomId);
		room.setRoomNumber(number);
		room.setRoomCapacity(capacity);

		int result = adminRoomService.update(room);
		if (result == 1) {
			model.addAttribute("tip", "更新成功");
		} else {
			model.addAttribute("tip", "更新失败");
		}

		room = adminRoomService.get(roomId);
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("room", room);
		model.addAttribute("building", room.getBuilding());

		return dispatcher;
	}

	/**
	 * 获取该建筑下的所有房间信息
	 * 
	 * @param buildingId
	 * @return json格式数据
	 */
	@RequestMapping("/getRoomsByBuildingId")
	@ResponseBody
	public List<RoomVO> getRoomsByBuildingId(int buildingId) {
		List<Room> rooms = adminRoomService.getByBuildingId(buildingId);
		List<RoomVO> list = new ArrayList<RoomVO>();
		Iterator<Room> iterator = rooms.iterator();
		while (iterator.hasNext()) {
			list.add(new RoomVO(iterator.next()));
		}
		return list;
	}
}
