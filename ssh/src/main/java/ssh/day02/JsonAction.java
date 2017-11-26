package ssh.day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonAction {
	private String name;
	private int age;
 
 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String execute() throws IOException{
		 
		name = "Tom";
		age = 10;
		return "success";
	}
	
}





