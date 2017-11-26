package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Mmap;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloColltroller {

	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		return "hello";
	}
	@RequestMapping("/bmi.do")
	public ModelAndView bmi(Bmi bp){
		System.out.println(bp);
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("status","正常");
		ModelAndView mav=new ModelAndView("view",data);
		return mav;
		
	}
	@RequestMapping("/bmi1.do")
	public String bmi1(HttpServletRequest request){
		request.setAttribute("status","正常");
		return "view";
	}
	@RequestMapping("/bmi2.do")
		public String bmi2(String height,String weight){
		System.out.println(height+"  "+weight);
			return "view";
		
	}
	@RequestMapping("/bmi6.do")
	public String bmi3(Bmi bp,ModelMap mm){

	}
	@RequestMapping("/bmi7.do")
	public String bmi(Bmi bp,HttpSession session)
	{
		System.out.println(bp);
		session.setAttribute("status", "正常");
		return "view";
	}
	@RequestMapping("/bmi.do")
	public String bmi8(){
		System.out.println("bmi8()");
		return "redirect:toindex.do";
	}
}
