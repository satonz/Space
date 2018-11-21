package space.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import space.po.Admin;

/**
 * 后台检查操作权限拦截器
 * 
 *
 */
public class AdminSessionInterceptor implements HandlerInterceptor {

	/**
	 * Controller处理之后执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {

	}

	/**
	 * Controller处理之后并且preHandle返回true执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * Controller处理之前执行，返回true继续执行；返回false直接退出，不执行Controller
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (null != admin) {
			return true;
		} else {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/admin/adminLogin");
			return false;
		}
	}

}
