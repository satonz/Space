package space.common;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Title:WEB-INF文件输出控制器 
 * Description: 负责WEB-INF目录下的文件输出
 * @date 2017年4月23日下午1:16:01
 */
@Controller
@RequestMapping(value = { "/fileController" })
public class FileController {

	@RequestMapping(value = { "/getImage" }, method = { RequestMethod.GET })
	/**
	 * 例如: fileController/getImage?fileName=test/123.jpg
	 * fileController/getImage?fileName=123.jpg
	 * 
	 * @Title: getImage
	 * @Description: TODO(获取WEB-INF下面的图片,当前路径为/Space)
	 * @param request
	 * @param response
	 * @param fileName
	 * @throws @date
	 *             2017年4月23日下午1:48:42 最近一次更新时间
	 */
	public void getImage(HttpServletRequest request, HttpServletResponse response, String fileName) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		realPath +=  "/" + fileName;
		// 载入图像
		BufferedImage buffImg = null;
		try {
			buffImg = ImageIO.read(new FileInputStream(realPath));
			// 将四位数字的验证码保存到Session中。
			// 禁止图像缓存。
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");
			// 将图像输出到Servlet输出流中。
			ServletOutputStream sos = null;
			sos = response.getOutputStream();
			ImageIO.write(buffImg, "jpeg", sos);
			sos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new RuntimeException();
		}

	}

}
