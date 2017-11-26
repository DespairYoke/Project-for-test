package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		EmployeeDAO dao=ac.getBean("empDAO",EmployeeDAO.class);
		Employee e=new Employee();
		e.setEname("苍老师");
		e.setAge(22);
		e.setSalary(2000);
		System.out.println(dao);
		System.out.println(dao.findAll());
	}

}
