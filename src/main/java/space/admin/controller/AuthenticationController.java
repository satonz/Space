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

import space.admin.service.AdminAuthenticationService;
import space.admin.service.AdminSystemInform;
import space.admin.service.StatisticalInforService;
import space.admin.vo.AuthenticationVO;
import space.admin.vo.Page;
import space.admin.vo.StatisticalInformation;
import space.po.Authentication;
import space.po.Sysinform;

@Controller("adminAuthenticationController")
@RequestMapping("/admin/authentication")
public class AuthenticationController {

	@Autowired
	private AdminAuthenticationService adminAuthenticationService;
	@Autowired
	private StatisticalInforService statisticalInforService;
	@Autowired
	private AdminSystemInform adminSystemInform;

	/**
	 * 
	 * @param aType
	 *            认证账号类型(学生1、老师2、社团3和学院4)
	 * @param type
	 *            检索类型(未处理0、已通过1、未通过2和全部检索3)
	 * @param retrieval
	 *            模糊查询
	 * @param currentPage
	 *            当前页
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "aType", defaultValue = "1") int aType,
			@RequestParam(name = "type", defaultValue = "0") int type,
			@RequestParam(name = "retrieval", defaultValue = "") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage, Model model) {
		String dispatcher = "admin/authentication";
		// 1.获取统计信息
		StatisticalInformation statisticalInformation = statisticalInforService.get();
		// 2.获取page
		int totalNumber = adminAuthenticationService.getTotalNumber(retrieval, aType, type);
		Page page = new Page(totalNumber, currentPage, 5);
		// 3.获取List<AuthenticationVO>
		List<AuthenticationVO> list = adminAuthenticationService.get(retrieval, aType, type, page);

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("aType", aType);
		model.addAttribute("type", type);
		model.addAttribute("retrieval", retrieval);

		return dispatcher;
	}

	/**
	 * 
	 * @param id
	 *            认证信息id
	 * @param status
	 *            处理类型(0通过认证,1不通过认证)
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<Object, Object> updata(int id, int status, String content) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		int result = 0;

		try {
			result = adminAuthenticationService.update(id, status);
			
			Authentication authentication = adminAuthenticationService.getAuthenticationByPrimaryKey(id);
			
			Sysinform sysinform = new Sysinform();
			sysinform.setReaded(false);
			sysinform.setSysinformTime(new Date());
			sysinform.setUser(authentication.getUser());
			if (status == 0) {
				//通过认证
				sysinform.setSysinformInfo("恭喜你，认证成功!");
			} else {
				sysinform.setSysinformInfo("你的认证信息不通过，原因是：" + content);
			}
			adminSystemInform.insertInform(sysinform );
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (result == 1) {
			map.put("status", "TRUE");
		} else {
			map.put("status", "FALSE");
		}
		return map;
	}

}
