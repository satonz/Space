package space.admin.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import space.admin.service.AdminLogService;
import space.admin.service.StatisticalInforService;
import space.admin.vo.Page;
import space.admin.vo.StatisticalInformation;

//@Controller("adminLogController")
@RequestMapping("/admin/log")
public class LogController {

	@Autowired
	private AdminLogService adminLogService;
	@Autowired
	private StatisticalInforService statisticalInforService;

	/**
	 * 
	 * @param type
	 *            日志类型0 普通日志; 1 错误日志
	 * @param retrieval
	 * @param page
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(name = "type", defaultValue = "0") int type,
			@RequestParam(name = "retrieval", defaultValue = ".") String retrieval,
			@RequestParam(name = "page", defaultValue = "1") int currentPage, HttpServletRequest request, Model model) {
		String dispatcher = "admin/log";
		String realPath = request.getServletContext().getRealPath("/logs/");

		StatisticalInformation statisticalInformation = statisticalInforService.get();

		// 1.获取查看日志类型的全部列表
		List<String> totalFileList = adminLogService.getFileList(realPath, type);
		// 2.符合查询条件的总数
		int totalNumber = adminLogService.getTotalNumber(retrieval, totalFileList);
		// 3.指定获取page
		Page page = new Page(totalNumber, currentPage, 20);
		// 4.获取该页记录
		List<String> fileList = adminLogService.list(retrieval, page, totalFileList);

		model.addAttribute("statisticalInformation", statisticalInformation);
		model.addAttribute("page", page);
		model.addAttribute("files", fileList);
		model.addAttribute("type", type);
		model.addAttribute("retrieval", retrieval);

		return dispatcher;
	}

	/**
	 * 获取日志内容
	 * 
	 * @param fileName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/get")
	public String get(String fileName, HttpServletRequest request, Model model) {
		String dispatcher = "admin/log-open";
		String realPath = request.getServletContext().getRealPath("/logs/");
		String path = realPath + fileName;
		FileReader reader;

		StatisticalInformation statisticalInformation = statisticalInforService.get();
		model.addAttribute("statisticalInformation", statisticalInformation);

		try {
			reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);
			StringBuffer content = new StringBuffer();
			String temp = null;
			while ((temp = bufferedReader.readLine()) != null) {
				content.append(temp + "<br />");
			}
			bufferedReader.close();

			model.addAttribute("content", content);
		} catch (IOException e1) {
			model.addAttribute("tip", "读取文件失败");
			e1.printStackTrace();
		}

		return dispatcher;
	}
}
