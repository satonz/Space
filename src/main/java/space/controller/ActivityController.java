package space.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import space.po.Activity;
import space.po.Barrage;
import space.po.Comment;
import space.po.Comminform;
import space.po.Reply;
import space.po.Ticket;
import space.po.User;
import space.service.ActivityService;
import space.service.BarrageService;
import space.service.CommentService;
import space.service.ComminformService;
import space.service.ReplyService;
import space.service.TicketService;
import space.service.UserService;
import space.util.Page;
/*
 * 活动模块的Controller
 */
@Controller
@RequestMapping("/act")
public class ActivityController {
	@Autowired
	private ActivityService activityService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private ReplyService replyService;

	@Autowired
	private UserService userService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private BarrageService barrageService;

	@Autowired
	private ComminformService cimService;

	/*
	 *  预告活动详情
	 */
	@RequestMapping("/foredetail/{id}")
	public ModelAndView foredetail(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();

		Activity act = activityService.selectById(id);
		int ticketNum = act.getTickets().size();
		mv.addObject("act", act);
		mv.addObject("ticketNum", ticketNum);
		mv.setViewName("jsp/activityForeDetail");
		return mv;
	}

	/*
	 *  往期活动详情
	 */
	@RequestMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		Activity act = activityService.selectById(id);

		mv.addObject("act", act);
		mv.setViewName("jsp/activityDetail");
		return mv;
	}

	/*
	 *  分页查询往期活动列表
	 */
	@RequestMapping("/actList")
	public ModelAndView detailList(HttpSession session, @RequestParam(value = "page", required = false) Integer page) {
		ModelAndView mv = new ModelAndView();
		if (page == null) {
			page = 1;
		}
		Page actPage = (Page) session.getAttribute("actPage");
		if (actPage == null) {
			int actNum = activityService.getPassActCount();
			int pageSize = 20;
			actPage = new Page();
			actPage.count(actNum, pageSize, page);
		} else {
			actPage.count(actPage.getTotalNumber(), actPage.getPageSize(), page);
		}
		session.setAttribute("actPage", actPage);
		List<Activity> passActs = activityService.getPassActsByPage(actPage);
		mv.addObject("passActs", passActs);

		mv.setViewName("jsp/activityList");
		return mv;
	}

	/*
	 *  用户ajax发表一级评论
	 */
	// 判断是否已登录 之后再改为用拦截器实现
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> comment(HttpSession session, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "content") String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			map.put("logined", "no");
			
			return map;
		}
		map.put("logined", "yes");

		// 判断是否存在id为id的活动
		Activity act = activityService.selectById(id);
		if (act == null) {
			map.put("act", "no");
			return map;
		}
		map.put("act", "yes");

		Comment comment = new Comment();
		comment.setActivity(act);
		comment.setUser(loginUser);
		comment.setCommentContent(content);
		commentService.save(comment);

		return map;
	}

	/*
	 *  用户ajax发表回复评论
	 */
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> reply(HttpSession session, @RequestParam(value = "commid") Integer commid,
			@RequestParam(value = "content") String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			map.put("logined", "no");
			return map;
		}
		map.put("logined", "yes");

		// 判断是否存在id为id的活动

		Comment comm = commentService.getCommentById(commid);

		if (comm == null) {
			map.put("comm", "no");
			return map;
		}

		map.put("comm", "yes");

		Reply reply = new Reply();
		reply.setComment(comm);
		reply.setUser(loginUser);
		reply.setReplyContent(content);
		try {
			replyService.save(reply);
			map.put("reply", "yes");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("reply", "no");
		}
		try {
			Comminform commInf = new Comminform();
			commInf.setComment(comm);
			commInf.setUser(loginUser);
			commInf.setReaded(false);
			cimService.save(commInf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	/*
	 * 活动报名
	 */
	@RequestMapping("/signup/")
	@ResponseBody
	public Map<String, Object> signup(HttpSession session, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();

		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			map.put("login", "no");
			return map;
		}
		map.put("login", "yes");
		Activity act = activityService.selectById(id);
		if (act == null) {
			map.put("act", "no");
			return map;
		}
		map.put("act", "yes");
		// 该活动是否需要入场券
		if (act.getActTicket() <= 0) {
			map.put("actticket", "no");
			return map;
		}
		map.put("actticket", "yes");

		// 判断该用户是否已经报名过，一个用户只能有一张入场券
		for (Ticket t : act.getTickets()) {
			if (t.getUser().getUserId() == loginUser.getUserId()) {
				map.put("nosignup", "no");
				return map;
			}
		}
		map.put("nosignup", "yes");
		synchronized (this) {	//同步代码块

			// 该活动是否有剩余入场券,若有剩余则存入一张新的入场券
			if (act.getTickets().size() > act.getActTicket()) {
				map.put("signup", "no");
				return map;
			}
			Ticket ticket = new Ticket();
			ticket.setActivity(act);
			ticket.setUser(loginUser);
			try {
				ticketService.save(ticket);
				map.put("signup", "yes");
				map.put("error", "noerror");
			} catch (Exception e) {
				System.out.println("-------\n\n");
				e.printStackTrace();
				map.put("error", "error");
			}
		}

		return map;
	}

	/*
	 * ajax发送弹幕
	 */
	@RequestMapping("/barrage/")
	@ResponseBody
	public Map<String, Object> barrage(HttpSession session, Integer id, String info) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			map.put("login", "no");
			return map;
		}
		map.put("login", "yes");
		
		if (id == null || info.equals("")) {
			map.put("form", "no");
			return map;
		}
		map.put("form", "yes");
		
		Activity act = activityService.selectById(id);
		if (act == null) {
			map.put("act", "no");
			return map;
		}
		map.put("act", "yes");
		Barrage barr = new Barrage();
		barr.setBarrInfo(info);
		barr.setUser(loginUser);
		barr.setActivity(act);
		try {
			barrageService.save(barr);
			map.put("barr", "yes");
		} catch (Exception e) {
			map.put("barr", "no");
		}
		return map;
	}

	/*
	 * 每次请求活动详情页面时请求该活动的最新n条弹幕
	 */
	@RequestMapping("/lastnbarr/")
	@ResponseBody
	public Map<String, Object> lastnbarr(HttpSession session, String id) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer actId = Integer.parseInt(id);
		Activity act = activityService.selectById(actId);
		if (act == null) {
			map.put("act", "no");
			return map;
		}
		map.put("act", "yes");

		int n = 30;		//查询最新的30条
		try {
			List<Barrage> lastnbarr = barrageService.getLastNByAct(act, n);

			map.put("lastN", lastnbarr);
			
			Map<Integer, Integer> actMaxBarr = new HashMap<Integer, Integer>();
			Integer maxId;
			if (lastnbarr.size() == 0) {
				maxId = 0;
			} else {
				//当前弹幕最大的id
				maxId = lastnbarr.get(0).getBarrId();
			}

			// 活动已获取的最大弹幕id，后面实时弹幕要用
			actMaxBarr.put(act.getActId(), maxId);
			session.setAttribute("actMaxBarr", actMaxBarr);

		} catch (Exception e) {
			map.put("lastN", "error");
			e.printStackTrace();
		}

		return map;
	}

	/*
	 * 实时弹幕：每次请求则向数据库查询id比当前session中最大弹幕id还大的弹幕，
	 * 		如果id比当前session中的最大id还大，说明这是新的弹幕
	 */
	@RequestMapping("/realTimeBarr/")
	@ResponseBody
	public Map<String, Object> realTimeBarr(HttpSession session, String id) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer actId = Integer.parseInt(id);
		Activity act = activityService.selectById(actId);
		if (act == null) {
			map.put("act", "no");
			return map;
		}
		map.put("act", "yes");

		Map<Integer, Integer> actMaxBarr = (Map<Integer, Integer>) session.getAttribute("actMaxBarr");
		if (actMaxBarr == null) {
			map.put("actMaxBarr", "no");
			return map;
		}
		map.put("actMaxBarr", "yes");
		if (!actMaxBarr.containsKey(act.getActId())) {
			map.put("maxId", "no");
			return map;
		}
		map.put("maxId", "yes");

		// 该活动的弹幕的以获取过的最大的id
		int maxId = actMaxBarr.get(act.getActId());

		try {
			List<Barrage> realTimeBass = barrageService.getActRealTimeBass(act, maxId);
			map.put("realTimeBass", realTimeBass);

			// 活动已获取的最大弹幕id
			if (realTimeBass.size() != 0) {
				// 最后一个是id最大值
				int newMaxId = realTimeBass.get(realTimeBass.size() - 1).getBarrId();
				//更新最大id
				actMaxBarr.put(act.getActId(), newMaxId);
				session.setAttribute("actMaxBarr", actMaxBarr);
			}

		} catch (Exception e) {
			map.put("realTimeBass", "error");
			e.printStackTrace();
		}
		return map;
	}
}
