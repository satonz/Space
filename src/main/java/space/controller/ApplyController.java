package space.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import space.po.Application;
import space.po.Authentication;
import space.po.Building;
import space.po.Room;
import space.po.User;
import space.service.ApplicationService;
import space.service.AuthenticationService;
import space.service.BuildingService;
import space.service.RoomService;
/*
 * 申请场地模块的Controller
 */
@Controller
@RequestMapping("/apply")
public class ApplyController {
	@Autowired
	private BuildingService buildingService;

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private ApplicationService applicationService;
	
	/*
	 * 申请场地的主页
	 */
	@RequestMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		//分别查询类型为教学楼,实验室和综合楼的所有Building
		List<Building> classBuildings = buildingService.getBuildingByType(Building.CLASSBUILDING);
		List<Building> labBuildings = buildingService.getBuildingByType(Building.LABBUILDING);
		List<Building> complexBuildings = buildingService.getBuildingByType(Building.COMPLEXBUILDING);

		mv.addObject("classBuildings", classBuildings);
		mv.addObject("labBuildings", labBuildings);
		mv.addObject("complexBuildings", complexBuildings);

		mv.setViewName("jsp/applyIndex");
		return mv;
	}

	/*
	 *  ajax确定能否申请该room，权限验证
	 */
	@RequestMapping(value = "/canapply", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> canapply(HttpSession session, @RequestParam(value = "bid") Integer bid) {
		Map<String, Object> map = new HashMap<String, Object>();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			map.put("logined", "no");
			return map;
		}
		map.put("logined", "yes");
		Authentication auth = authService.selectByUser(loginUser);
		// 未有认证
		if (auth == null) {
			map.put("auth", "null");
			return map;
		}
		// 已有认证类型
		map.put("auth", auth.getTypeToString(auth.getInfType()));
		// 是否已通过认证
		if (auth.getInfStatus() == false) {
			map.put("status", "no");
			return map;
		}
		map.put("status", "yes");
		Building building = buildingService.getBuildingById(bid);
		// id为bid的building不存在
		if (building == null) {
			map.put("building", "null");
			return map;
		}
		// 若存在则判断该用户是否能够申请
		int btype = building.getBuiType();
		int authtype = auth.getInfType();
		map.put("canapply", validCanApply(btype, authtype));
		return map;
	}

	/*
	 *  验证是否能申请，设定规则
	 */
	public String validCanApply(int btype, int authtype) {
		String canapply = null;
		switch (btype) {
		// 如果申请的场地的类型是教学楼的课室，则所有类型都可以申请
		case Building.CLASSBUILDING:
			canapply = "yes";
			break;
		// 如果申请的场地是综合楼的，则需要社团或院系才可以
		case Building.COMPLEXBUILDING:
			if (authtype == Authentication.INF_ASSOCIATION || authtype == Authentication.INF_INSTITUTE) {
				canapply = "yes";
			} else {
				canapply = "no";
			}
			break;
		// 如果申请的是实验室的，则需要教师才可以
		case Building.LABBUILDING:
			if (authtype == Authentication.INF_TEACHER) {
				canapply = "yes";
			} else {
				canapply = "no";
			}
			break;
		default:
			canapply = "no";
		}
		return canapply;
	}

	/*
	 *  提交申请表单：需要再次验证权限，检查时间冲突
	 */
	@RequestMapping(value = "/applyForm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> applyForm(HttpSession session, Integer buiId, Integer roomId, String startTime,
			String endTime, String reason) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (buiId == null || roomId == null || startTime == "" || endTime == "" || reason == "") {
			map.put("form", "no");
			return map;
		}
		map.put("form", "yes");
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			map.put("login", "no");
			return map;
		}
		map.put("login", "yes");
		Authentication auth = authService.selectByUser(loginUser);
		if (auth == null) {
			map.put("auth", "no");
			return map;
		}
		map.put("auth", "yes");
		Building building = buildingService.getBuildingById(buiId);
		if (building == null) {
			map.put("building", "no");
			return map;
		}
		// 是否已通过认证
		if (auth.getInfStatus() == false) {
			map.put("status", "no");
			return map;
		}
		map.put("status", "yes");
		map.put("building", "yes");
		int btype = building.getBuiType();
		int authtype = auth.getInfType();
		if (validCanApply(btype, authtype) == "no") {
			map.put("canapply", "no");
			return map;
		}
		map.put("canapply", "yes");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		try {
			if (sdf.parse(startTime.replace("T", " ")).before(new Date(System.currentTimeMillis()))) {
				map.put("startTime", "no");
				System.out.println("开始时间不能小于当前时间");
				return map;
			} else {
				map.put("startTime", "yes");
			}
		} catch (ParseException e1) {
			
			e1.printStackTrace();
			map.put("startTime", "error");

		}
		Application application = new Application();
		try {
			application.setAppStartTime(sdf.parse(startTime.replace("T", " ")));
			application.setAppEndTime(sdf.parse(endTime.replace("T", " ")));
		} catch (ParseException e) {
			
			e.printStackTrace();
			map.put("time", "no");
			return map;
		}

		application.setAppInfo(reason);

		Room room = roomService.getRoomById(roomId);
		if (room == null) {
			map.put("room", "no");
			return map;
		}
		map.put("room", "yes");
		application.setRoom(room);
		// 再检查一下在该时间段该课室是否被占用了，即检查是否存在时间段冲突
		try {
			List<Application> existApps = applicationService.checkTimeConflict(application);
			if (existApps.size() == 0) {
				map.put("existApps", "yes");
			} else {
				map.put("existApps", "no");
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("existApps", "error");
			return map;
		}

		application.setUser(loginUser);
		application.setAppStatus(false);
		application.setAppIsDealed(false);
		try {
			applicationService.save(application);
		} catch (Exception e) {
			map.put("app", "no");
			return map;
		}
		map.put("app", "yes");
		return map;

	}

	/*
	 * ajax查看未来一周的使用情况
	 */
	@RequestMapping(value = "/weekUse", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> weekUse(HttpSession session, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();

		Date startTime = new Date(); // 从现在起
		int dateNum = 7; // n 天内的
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, dateNum);
		Date endTime = calendar.getTime();

		try {

			Room room = roomService.getRoomById(id);
			if (room == null) {
				map.put("room", "no");
				return map;
			}
			map.put("room", "yes");
			Application app = new Application();
			app.setRoom(room);

			app.setAppStartTime(startTime);
			app.setAppEndTime(endTime);

			//System.out.println("场地信息：" + app.getRoom().toString());

			List<Application> apps = applicationService.checkTimeConflict(app);
			
			List<Application> applications = new ArrayList<>();
			Iterator<Application> iterator = apps.iterator();
			while (iterator.hasNext()) {
				Application next = iterator.next();
				Application application = new Application(next.getAppTime(), next.getAppStartTime(), next.getAppEndTime(), null, null, null, null, null);
				applications.add(application);
			}
			
			map.put("apps", applications);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("apps", "error");
		}

		return map;
	}
}
