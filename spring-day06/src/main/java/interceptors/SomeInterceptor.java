package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements 
HandlerInterceptor{

	/**
	 * 整个请求处理完毕，最后执行的方法。
	 * arg3:（了解）
	 * 	处理器方法所抛出的异常。
	 */
	public void afterCompletion(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, Object arg2, 
			Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}

	/**
	 * 处理器(Controller)的方法执行完毕，正准备将
	 * 处理结果(ModelAndView)返回给DispatcherServlet
	 * 之前，执行postHandle方法。
	 * 注：
	 * 	可以在该方法里面，修改处理结果(ModelAndView)。
	 */
	public void postHandle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2,
			ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle()");
	}

	/**
	 * DispatcherServlet在收到请求之后，会先调用
	 * 拦截器的preHandle方法。
	 * 如果该方法的返回值是true,是继续向后执行；
	 * 如果该方法的返回值是false,则中断请求，返回结果。
	 * arg2:(了解)
	 * 	处理器方法对象
	 */
	public boolean preHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, Object arg2)
					throws Exception {
		System.out.println("preHandle()");
		return true;
	}
	
}


