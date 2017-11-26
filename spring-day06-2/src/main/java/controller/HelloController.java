package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@ExceptionHandler
	/*
	 *  e:处理器方法所抛出的异常
	 */
	public String handleEx(Exception e,
			HttpServletRequest request){
		System.out.println("handleEx()");
		if(e instanceof NumberFormatException){
			request.setAttribute("msg",
					"亲，请输入合法的数字");
			return "error3";
		}
		if(e instanceof StringIndexOutOfBoundsException){
			request.setAttribute("msg", "下标越界啦");
			return "error3";
		}
		//其它异常
		return "error";
	}
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		Integer.parseInt("123a");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2()");
		"1234".charAt(8);
		return "hello";
	}
	
	
}




