package space.admin.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("exception", exception);

		ModelAndView modelAndView = null;
		// 根据不同错误转向不同页面
		if (exception instanceof RuntimeException) {
			modelAndView = new ModelAndView("redirect:/runtime-exception.jsp", model);
		}

		return modelAndView;
	}

}
