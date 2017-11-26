package cn.tedu.ems.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.AppException;
import cn.tedu.ems.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	LoginService loginService;
	
	
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request){
		System.out.println("login()");
		String username = 
				request.getParameter("uname");
		String pwd = 
				request.getParameter("pwd");
		System.out.println("username:" 
				+ username + " pwd:" + pwd);
		try{
			
		
	User user=loginService.checkLogin(username, pwd);
		
	}catch(Exception e){
		e.printStackTrace();
		if(e instanceof AppException)
		{
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		return "error";
	}
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
}









