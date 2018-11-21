package space.admin.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import space.admin.service.AdminAdminService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.ApplicationVO;
import space.admin.vo.StatisticalInformation;
import space.po.Admin;
import space.util.MyMD5;

/**
 * 后台首页、登录、注销控制器
 * 
 */
@Controller("adminAdminController")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminAdminService adminAdminService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 登录成功后进入首页
	 * 
	 * @return
	 */
	@RequestMapping(path = { "", "/" })
	public String index(Model model, HttpServletRequest request) {
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		// 2.获取未来7天场地使用信息
		List<ApplicationVO> applications0 = adminAdminService.getApplicationsIntNDays(0);
		List<ApplicationVO> applications1 = adminAdminService.getApplicationsIntNDays(1);
		List<ApplicationVO> applications2 = adminAdminService.getApplicationsIntNDays(2);
		List<ApplicationVO> applications3 = adminAdminService.getApplicationsIntNDays(3);
		List<ApplicationVO> applications4 = adminAdminService.getApplicationsIntNDays(4);
		List<ApplicationVO> applications5 = adminAdminService.getApplicationsIntNDays(5);
		List<ApplicationVO> applications6 = adminAdminService.getApplicationsIntNDays(6);
		// 3.获取未来7天的时间
		List<Date> dates = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
		int n = 0;
		do {
			dates.add(calendar.getTime());
			calendar.add(Calendar.DAY_OF_MONTH, +1); // 取当前日期的后1天
			n++;
		} while (n <= 6);

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("applications0", applications0);
		model.addAttribute("applications1", applications1);
		model.addAttribute("applications2", applications2);
		model.addAttribute("applications3", applications3);
		model.addAttribute("applications4", applications4);
		model.addAttribute("applications5", applications5);
		model.addAttribute("applications6", applications6);
		model.addAttribute("dates", dates);

		return "admin/index";
	}

	/**
	 * 跳转到后台登录页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/adminLogin")
	public String adminLogin(Model model) {
		String dispatcher = "admin/adminLogin";
		return dispatcher;
	}

	/**
	 * 后台登录
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String email, String password, HttpSession session, Model model) {
		String dispatcher = "redirect:adminLogin";

		password = MyMD5.encrypt(password);
		Admin admin = adminAdminService.login(email, password);
		// 如果登录成功，则进入后台首页，否则返回后台登录界面
		if (null != admin) {
			session.setAttribute("admin", admin);
			dispatcher = "redirect:./";
		} else {
			model.addAttribute("tip", "账号或密码错误");
		}
		return dispatcher;
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		String dispatcher = "redirect:adminLogin";
		request.getSession().removeAttribute("admin");
		return dispatcher;
	}

	/**
	 * 跳转到修改密码页面
	 * 
	 * @return
	 */
	@RequestMapping("/toPwdReset")
	public String toPwdReset(Model model) {
		String dispatcher = "admin/password-reset";

		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);

		return dispatcher;
	}

	/**
	 * 修改密码
	 * 
	 * @param oldPwd
	 * @param newPwd
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/updatePwd")
	public String updatePwd(String oldPwd, String newPwd, Model model, HttpSession session) {
		String dispatcher = "redirect:updatePwd";

		oldPwd = MyMD5.encrypt(oldPwd);
		newPwd = MyMD5.encrypt(newPwd);

		int userId = ((Admin) session.getAttribute("admin")).getAdminId();
		int result = adminAdminService.updatePwd(userId, oldPwd, newPwd);
		if (result == 1) {
			model.addAttribute("tip", "修改成功");
			session.removeAttribute("admin");
		} else {
			model.addAttribute("tip", "修改失败");
			dispatcher = "redirect:toPwdReset";
		}

		return dispatcher;
	}
	
	@RequestMapping("/toAddAdmin")
	public String toAddAdminPage (Model model) {
		
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		return "admin/admin-add";
	}
	
	@RequestMapping("/add")
	public String add (String name, String email, String pwd, Model model) {
		
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(MyMD5.encrypt(pwd));
		
		int result = 0;
		try {
			result = adminAdminService.save(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 1) {
			model.addAttribute("tip", "新增管理员成功!");
		} else {
			model.addAttribute("tip", "新增管理员失败!");
			model.addAttribute("name", name);
			model.addAttribute("email", email);
		}
		
		
		return "admin/admin-add";
	}

}
