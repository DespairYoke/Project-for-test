package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Student;

public class TestCase3 {
	@Autowired
	Student s;
	@Test
	public void test1(){
		System.out.println(s);
	}
	
}
