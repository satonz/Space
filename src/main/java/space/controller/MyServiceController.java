package space.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import space.po.Application;
import space.po.Comminform;
import space.po.Sysinform;
import space.po.Ticket;
import space.po.User;
import space.service.ActivityService;
import space.service.ApplicationService;
import space.service.ComminformService;
import space.service.SysinformService;
import space.service.TicketService;
import space.service.UserService;

/*
 * 我的服务模块的Controller，负责 我的通知，我的场地，我的活动等
 */
@Controller
@RequestMapping("myservice")
public class MyServiceController {

	@Autowired
	private ActivityService activityService;

	@Autowired
	private UserService userService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private ComminformService comminformService;

	@Autowired
	private SysinformService sysinformService;

	@Autowired
	private ApplicationService appService;

	/*
	 * 获取未读通知数量：这里采用ajax请求，前台每进入一个页面，
	 * 			就会通过ajax请求未读通知的数量，以Json格式返回评论通知和系统通知的数量
	 */
	@RequestMapping(value = "/unReadInf", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> unReadInf(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			map.put("login", "no");
			return map;
		}
		map.put("login", "yes");
		try {
			//查询系统通知和评论通知的数量
			int commInfNum = comminformService.getUnReadNumByUser(loginUser);
			int sysInfNum = sysinformService.getUnReadNumByUser(loginUser);
			map.put("commInfNum", commInfNum);
			map.put("sysInfNum", sysInfNum);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("commInfNum", "error");
			map.put("sysInfNum", "error");
		}

		return map;
	}

	/*
	 * 查看所有通知：查询所有系统通知和评论通知，并把所有未读通知设置为已读
	 */
	@RequestMapping("myinforms")
	public ModelAndView myinforms(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			mv.addObject("message", "用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		List<Comminform> comminforms = null;
		List<Sysinform> sysinforms = null;
		try {
			comminforms = comminformService.getAllByUser(loginUser);
			sysinforms = sysinformService.getAllByUser(loginUser);

		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("message", "服务器发生了一些错误");
			mv.setViewName("redirect:/index");
			return mv;
		}
		// 把所有未读的更新为已读
		try {
			comminformService.updateAllToReaded(loginUser);
			sysinformService.updateAllToReaded(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("comminforms", comminforms);
		mv.addObject("sysinforms", sysinforms);
		mv.setViewName("jsp/myservice/myInform");

		return mv;
	}

	/*
	 * 我的活动：查询我的所有入场券
	 */
	@RequestMapping("/myacts")
	public ModelAndView myacts(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			mv.addObject("message", "用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		try {
			List<Ticket> tickets = ticketService.getTicketByUser(loginUser);
			mv.addObject("tickets", tickets);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("jsp/myservice/myActs");
		return mv;
	}

	/*
	 * get请求进入 打印入场券 的页面
	 */
	@RequestMapping("/printTicket")
	public ModelAndView printTicket(HttpSession session, Integer tid) {
		ModelAndView mv = new ModelAndView();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			mv.addObject("message", "用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		Ticket ticket = ticketService.getTicketById(tid);
		if (ticket.getUser().getUserId() != loginUser.getUserId()) {
			mv.addObject("message", "该门票不属于当前用户");
			mv.setViewName("redirect:/index");
			return mv;
		}
		mv.addObject("ticket", ticket);
		mv.setViewName("jsp/myservice/printTicket");
		return mv;
	}

	/*
	 * 我的场地
	 */
	@RequestMapping("/myrooms")
	public ModelAndView myrooms(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			mv.addObject("message", "用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		try {
			//查询所有我所有已通过批准的场地申请单
			List<Application> apps = appService.getAppByUser(loginUser);
			mv.addObject("apps", apps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("jsp/myservice/myRooms");
		return mv;
	}

}
