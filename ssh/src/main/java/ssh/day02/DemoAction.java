package ssh.day02;

import org.springframework.stereotype.Controller;

@Controller//BeanID: demoAction
public class DemoAction {
	
	public String execute(){
		System.out.println("Hello World!");
		return "success";
	}
}
