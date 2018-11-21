package space.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import space.admin.service.StatisticalInforService;
import space.admin.vo.StatisticalInformation;
import space.admin.vo.SystemInformation;

@Controller("adminSettingController")
@RequestMapping("/admin/setting")
public class SettingController {

	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 跳转到设置页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = { "", "/" })
	public String setting(Model model, HttpServletRequest request) {
		String dispatcher = "admin/setting";
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);
		// 2.获取操作系统、服务器相关信息
		SystemInformation systemInformation = new SystemInformation(request);
		model.addAttribute("systemInformation", systemInformation);

		return dispatcher;
	}

}
