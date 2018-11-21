package space.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import space.po.Action;
import space.po.Authentication;
import space.po.Image;
import space.po.Profile;
import space.po.User;
import space.service.ActionService;
import space.service.AuthenticationService;
import space.service.ImageService;
import space.service.ProfileService;
import space.service.UserService;
import space.util.FileUploadUtil;
import space.util.GetAddrIP;
import space.util.ImgCut;
import space.util.MyMD5;
import space.util.Result;

/*
 * 前台用户个人信息管理模块Controller
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * 所需要的服务的对象，spring Ioc 自动注入对象
	 */
	@Resource
	private UserService userService;

	@Resource
	private ProfileService profileService;

	@Resource
	private AuthenticationService authService;

	@Resource
	private ImageService imgService;
	
	//用户行为记录
	@Resource
	private ActionService actionService;

	/**
	 * 用户登录方法，采用ajax验证用户名和密码
	 * @param user 用户登录时提交的用户名和密码等信息自动封装到user中
	 * @return map 返回校验结果
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(HttpSession session, HttpServletRequest request,
			@ModelAttribute(value = "user") User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		//验证用户名和密码，如果验证成功，则返回验证成功的用户对象，验证不成功则返回null
		User loginUser = userService.login(user);
		
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			try {
				Profile profile = profileService.selectByUser(loginUser);
				session.setAttribute("profile", profile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 用户行为记录
			try {
				String ip = GetAddrIP.getIpAddr((HttpServletRequest) request);

				Action action = new Action();
				action.setActionIp(ip);
				action.setUser(loginUser);
				action.setActionName("登录");
				actionService.save(action);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("登录成功");
			map.put("login", "yes");
			return map;
		}

		map.put("login", "no");
		map.put("message", "用户名或密码错误");
		return map;
	}

	/**
	 * 用户注册
	 * @param user 用户的注册信息都封装在user中
	 * @param password2 用户的确认密码，需要验证确认密码和密码是否一致
	 * @return map 以json格式返回注册结果
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> regist(HttpSession session, HttpServletRequest request,
			@ModelAttribute(value = "user") User user,
			@RequestParam(value = "password2", required = true) String password2) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null) {
			map.put("valid", "no");
			map.put("message", "表单未填完整");
			return map;
		}
		boolean pswEQ = password2.equals(user.getPassword());
		if (pswEQ == false) {

			map.put("valid", "no");
			map.put("message", "两次密码不一致");
			return map;
		}
		User existuser = userService.selectByName(user.getUsername());
		if (existuser != null) {
			map.put("valid", "no");
			map.put("message", "用户名已存在！");
			return map;
		}
		existuser = userService.selectByEmail(user.getEmail());
		if (existuser != null) {
			map.put("valid", "no");
			map.put("message", "该邮箱已被注册！");
			return map;
		}

		try {
			user = userService.regist(user);

		} catch (Exception e) {
			e.printStackTrace();
			map.put("valid", "no");
			map.put("message", "user服务器发生了一些错误！");
			return map;
		}
		// user = userService.selectByName(user.getUsername());

		Profile profile = new Profile();
		profile.setUser(user);
		profile.setPfAvatar("/upload/image/default1.jpg");// 默认头像路径
		try {
			profileService.save(profile);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("valid", "no");
			map.put("message", "profile服务器发生了一些错误！");
			return map;
		}

		session.setAttribute("loginUser", user);
		session.setAttribute("profile", profile);
		try {
			String ip = GetAddrIP.getIpAddr(request);

			Action action = new Action();
			action.setActionIp(ip);
			action.setUser(user);
			action.setActionName("注册");
			actionService.save(action);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("valid", "yes");
		map.put("message", "账户注册成功！");
		return map;
	}

	/**
	 * 退出登录：将用户session中的所有数据清除
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public Map<String, Object> logout(HttpSession session, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			try {
				String ip = GetAddrIP.getIpAddr(request);

				Action action = new Action();
				action.setActionIp(ip);
				action.setUser(loginUser);
				action.setActionName("退出登录");
				actionService.save(action);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (session != null) {
			session.removeAttribute("loginUser");
			Enumeration<String> em = session.getAttributeNames();
			while (em.hasMoreElements()) {
				session.removeAttribute(em.nextElement().toString());
			}
			session.invalidate();
		}

		map.put("logout", "yes");
		return map;
	}

	/**
	 * 进入用户个人主页：展示用户的个人信息
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		//查询用户的个人信息
		Profile profile = profileService.selectByUser(loginUser);
		mv.addObject("profile", profile);
		mv.addObject("current", "index");
		mv.setViewName("jsp/userhome/basic");
		return mv;
	}

	/*
	 * get请求进入 修改个人信息页面 
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		Profile profile = profileService.selectByUser(loginUser);
		mv.addObject("profile", profile);
		mv.addObject("current", "edit");
		mv.setViewName("jsp/userhome/editbasic");
		return mv;
	}

	/*
	 * 修改修改个人信息：post提交表单，逐个更新profile的字段
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editpost(HttpSession session, @ModelAttribute(value = "profile") Profile profile, String birth)
			throws ParseException {
		ModelAndView mv = new ModelAndView();

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		
		Profile pf = profileService.selectByUser(loginUser);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (birth != "") {
			try{
				pf.setPfBirth(sdf.parse(birth));
			}catch(Exception e){
				//e.printStackTrace();
			}
		}
		//将表单中的数据逐个赋值给profile
		System.out.println("生日："+birth);

		pf.setPfSex(profile.getPfSex());
		pf.setPfPhone(profile.getPfPhone());
		pf.setPfQq(profile.getPfQq());
		pf.setPfRealname(profile.getPfRealname());

		profileService.update(pf);

		mv.addObject("message", "成功修改个人信息");
		mv.setViewName("redirect:/user/index");
		return mv;
	}

	/*
	 * get请求用户认证页面：查询用户的认证信息和认证相对应的认证图片信息
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public ModelAndView authget(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}
		//从数据库中查询当前用户的认证表，如果查询不到说明当前用户暂未认证
		Authentication authentication = authService.selectByUser(loginUser);
		if (authentication != null) {
			mv.addObject("authentication", authentication);
			List<Image> authimgs = imgService.getImageByAuth(authentication);
			
			mv.addObject("authimgs", authimgs);
		}

		mv.addObject("current", "auth");
		mv.setViewName("jsp/userhome/auth");
		return mv;
	}

	/*
	 * 用户提交认证表单：先查询是否已经提交过，若未提交过则保存认证信息，并保存图片
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> authenticate(HttpServletRequest request, HttpSession session,
			Authentication authentication, String authimgs) {
		Map<String, Object> map = new HashMap<String, Object>();

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			map.put("login", "no");
			return map;
		}
		map.put("login", "yes");
		// 判断是否已经提交了认证申请
		Authentication auth1 = authService.selectByUser(loginUser);
		if (auth1 != null) {
			if (auth1.getInfStatus() == true) {
				map.put("auth1", "no");
				return map;
			}
		}
		map.put("auth1", "yes");

		authentication.setUser(loginUser);
		authentication.setInfStatus(false);
		authentication.setInfIsDealed(false);
		Authentication auth = authService.save(authentication);
		if (null == auth) {

			map.put("auth", "no");
			return map;
		}
		map.put("auth", "yes");
		//保存认证图片的路径，认证图片已经异步上传，在这里获得图片的路径，图片的路径用分号分割
		String[] imgPaths = authimgs.split(";");
		for (String path : imgPaths) {
			Image img = new Image();
			img.setAuthentication(authentication);
			img.setImgPath(path);
			try {
				imgService.save(img);
			} catch (Exception e) {

				map.put("imgs", "no");
				authService.delete(authentication);
				return map;
			}

		}
		map.put("imgs", "yes");
		return map;
	}
	/*
	 * 再次认证:当用户提交的认证不被批准，用户可以再次认证，
	 * 		在这里把之前认证不通过的对象删除，并重定向到认证页面
	 */
	@RequestMapping(value = "/authAgain")
	public ModelAndView authAgain(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			mv.setViewName("redirect:/index");
			return mv;
		}
		
		
		Authentication auth = authService.selectByUser(loginUser);
		if (auth != null) {
			//如果用户之前已经提交的认证状态为false并且已经被处理，则删除
			if (auth.getInfStatus() == false && auth.getInfIsDealed() == true) {
				authService.delete(auth);
			}
		}
		
		mv.setViewName("redirect:/user/auth");
		return mv;
	}

	/*
	 * fileinput插件ajax上传认证图片
	 */
	@RequestMapping("/authimg")
	@ResponseBody
	public Map<String, Object> authimg(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("authimg") MultipartFile myFile) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 输出文件后缀名称
			System.out.println(myFile.getOriginalFilename());
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			// 图片名称
			String name = df.format(new Date());

			Random r = new Random();
			for (int i = 0; i < 3; i++) {
				name += r.nextInt(10);
			}
			//获取后缀
			String ext = FilenameUtils.getExtension(myFile.getOriginalFilename());
			// 保存图片 File位置 （全路径） /upload/fileName.jpg
			String url = request.getSession().getServletContext().getRealPath("/WEB-INF/authImage/");
			// 相对路径
			String path = "/" + name + "." + ext;
			File file = new File(url);
			if (!file.exists()) {
				file.mkdirs();
			}
			myFile.transferTo(new File(url + path));
			map.put("success", "/WEB-INF/authImage" + path);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * get请求 进入修改头像页面
	 */
	@RequestMapping(value = "/avatar")
	public ModelAndView avatar(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}

		mv.addObject("current", "avatar");
		mv.setViewName("jsp/userhome/avatar");
		return mv;
	}

	/*
	 * ajax上传头像：保存头像，切割头像，存储新的头像，返回结果
	 */
	@RequestMapping(value = "/avatarupload", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String avatarupload(HttpSession session,
			@RequestParam(value = "avatar_file", required = false) MultipartFile avatar_file, String avatar_src,
			String avatar_data, HttpServletRequest request) {
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");

			return JSON.toJSONString(new Result(null, "上传失败：未登录"));
		}

		System.out.println("==========Start=============");
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String resourcePath = "/upload/image/";
		// 判断文件的MIMEtype
		String type = avatar_file.getContentType();
		if (type == null || !FileUploadUtil.allowUpload(type))
			return JSON.toJSONString(new Result(null, "不支持的文件类型，仅支持图片！"));
		System.out.println("file type:" + type);
		String fileName = FileUploadUtil.rename(avatar_file.getOriginalFilename());
		int end = fileName.lastIndexOf(".");
		String saveName = fileName.substring(0, end);
		try {
			File dir = new File(realPath + resourcePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, saveName + "_src.jpg");
			avatar_file.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(null, "上传失败，出现异常：" + e.getMessage()));
		}
		String srcImagePath = realPath + resourcePath + saveName;
		JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
		// 用户经过剪辑后的图片的大小
		// 用户经过剪辑后的图片的大小
		float x = joData.getFloatValue("x");
		float y = joData.getFloatValue("y");
		float w = joData.getFloatValue("width");
		float h = joData.getFloatValue("height");
		float r = joData.getFloatValue("rotate");
		// 这里开始截取操作
		System.out.println("==========imageCutStart=============");
		ImgCut.cutAndRotateImage(srcImagePath, (int) x, (int) y, (int) w, (int) h, (int) r);
		System.out.println("==========imageCutEnd=============");
		System.out.println(resourcePath + saveName + "_cut.jpg\n");
		Profile profile = (Profile) session.getAttribute("profile");
		profile.setPfAvatar(resourcePath + saveName + "_cut.jpg");
		profileService.update(profile);
		session.setAttribute("profile", profile);
		return JSON.toJSONString(new Result(
				request.getSession().getServletContext().getContextPath() + resourcePath + saveName + "_cut.jpg",
				"上传成功!"));
	}

	/*
	 * get请求进入 修改密码 页面
	 */
	@RequestMapping(value = "/editpass", method = RequestMethod.GET)
	public ModelAndView editpass(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}

		mv.addObject("current", "editpass");
		mv.setViewName("jsp/userhome/changePass");
		return mv;
	}

	/*
	 * ajax修改密码：判断旧密码是否正确，判断两次密码是否正确，保存
	 */
	@RequestMapping(value = "/editpass", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editpassPost(HttpSession session, String old_password, String new_password1,
			String new_password2) {
		Map<String, Object> map = new HashMap<String, Object>();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			map.put("login", "no");
			return map;
		}
		map.put("login", "yes");
		if (old_password == "" || new_password1 == "" || new_password2 == "") {
			map.put("form", "no");
		}
		map.put("form", "yes");
		boolean pswEQ = MyMD5.encrypt(old_password).equals(loginUser.getPassword());
		if (pswEQ != true) {
			map.put("old", "no");
			return map;
		}
		map.put("old", "yes");
		if (!new_password1.equals(new_password2)) {
			map.put("new", "no");
			return map;
		}
		map.put("new", "yes");
		try {
			loginUser.setPassword(MyMD5.encrypt(new_password1));
			userService.update(loginUser);
			map.put("op", "yes");
		} catch (Exception e) {
			map.put("op", "no");
		}

		return map;
	}

	/**
	 * 修改邮箱
	 */
	/*@RequestMapping(value = "/editemail")
	public ModelAndView editemail(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			System.out.println("用户未登录");
			mv.setViewName("redirect:/index");
			return mv;
		}

		mv.addObject("current", "editemail");
		mv.setViewName("jsp/userhome/changeEmail");
		return mv;
	}*/

}
