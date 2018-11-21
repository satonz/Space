package space.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import space.admin.service.AdminUserService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.Page;
import space.admin.vo.StatisticalInformation;
import space.admin.vo.UserVO;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private AdminUserService adminUserService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 
	 * @param retrieval
	 * @param type
	 *            检索的账号类型：0全部，1学生，2老师，3社团，4学院，5未认证
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "type", defaultValue = "0") int type,
			@RequestParam(name = "page", defaultValue = "1") int currentPage, Model model) {
		String dispatcher = "admin/user";
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		// 2.获取page
		int totalNumber = adminUserService.getTotalNumber(retrieval, type);
		Page page = new Page(totalNumber, currentPage, 15);
		// 3.获取List<UserVO>
		List<UserVO> list = adminUserService.get(retrieval, type, page);

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("retrieval", retrieval);
		model.addAttribute("type", type);

		return dispatcher;
	}

}
