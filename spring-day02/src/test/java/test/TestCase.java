package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import value.Student;

public class TestCase {
	@Test
	//测试 注入基本类型的值
	public void test1(){
		String config = "value.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu1);
		
	}
	
	@Test
	//测试 引用的方式注入集合类型的值
	public void test2(){
		String config = "value.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		Student stu2 = 
				ac.getBean("stu2",Student.class);
		System.out.println(stu2);
		
	}
	
	@Test
	//测试 读取properties文件
	public void test3(){
		String config = "value.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Properties props = 
				ac.getBean("config",Properties.class);
		System.out.println(props);
		
	}
}








