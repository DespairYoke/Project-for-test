package ssh.day03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class TestAction {
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		Thread t = Thread.currentThread();
		System.out.println(t+" set "+name);
	}
	public String save() throws Exception{
		Thread.sleep(5000);
		Thread t = Thread.currentThread();
		System.out.println(t+" save "+name);
		return "success";
	}
}



