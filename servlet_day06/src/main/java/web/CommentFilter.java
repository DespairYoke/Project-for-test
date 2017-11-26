package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CommentFilter implements Filter{
	private FilterConfig config;
	/**
	 * 容器在销毁过滤器实例之前，会调用此方法。
	 */
	public void destroy() {
		System.out.println("destroy()");
	}

	/**
	 * 容器会调用doFilter方法来处理请求
	 * FilterChain（过滤器链）：如果调用了该对象的
	 * doFilter方法，则继续向后执行，否则中断请求。
	 */
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("doFilter begin...");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String content = request.getParameter(
				"content");
		
		//读取初始化参数
		String illegal = 
				config.getInitParameter("illegal");
		
		if(content.indexOf(illegal) != -1){
			out.println("<h1>评论内容非法</h1>");
		}else{
			//继续向后执行
			arg2.doFilter(request, response);
		}
		System.out.println("doFilter end.");
	}
	
	/**
	 * 容器启动之后，会立即创建过滤器实例（只会创建一个）
	 * 接下来，会调用该实例的init方法（只会执行一次）
	 * FilterConfig:用来读取初始化参数。
	 */
	public void init(FilterConfig arg0) 
			throws ServletException {
		System.out.println("init()");
		//将容器传递过来的FilterConfig对象保存下来
		config = arg0;
	}

	public CommentFilter() {
		System.out.println("CommentFilter()");
	}
	
	
	
	
	

}
