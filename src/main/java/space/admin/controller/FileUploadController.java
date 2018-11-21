package space.admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/admin/file")
public class FileUploadController {

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public List<String> fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
		// 获取文件名
		String fileName = file.getOriginalFilename();
		String[] strings = fileName.split("\\.");
		System.out.println(strings.length + strings[0]);
		long time = new Date().getTime();
		fileName = time + "." + strings[strings.length - 1];
		// 获取上传文件的路径
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/admin/file/upload/image");
		System.out.println("path:" + path);
		try {
			InputStream inputStream = file.getInputStream();
			OutputStream outputStream = new FileOutputStream(new File(path, fileName));
			System.out.println("全路径:" + path + fileName);
			int lenght = 0;
			byte[] buffer = new byte[400];
			while ((lenght = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, lenght);
			}
			outputStream.close();
			inputStream.close();
			String serverName = "http://" + request.getServerName() + ":" + request.getServerPort();
			String requestURI = request.getRequestURI();
			list.add(0, "TRUE");
			list.add(1, "/admin/file/upload/image/" + fileName);
		} catch (IOException e) {
			System.out.println("获取上传文件流出错");
			list.add("FALSE");
		}
		return list;
	}
}
