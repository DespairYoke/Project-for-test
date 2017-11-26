package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	private EmployeeDAO dao;
	@Before
	public void init(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"spring-mybatis.xml");
		dao = ac.getBean("empDAO",
								EmployeeDAO.class);
	}
	
	@Test
	public void test1(){
		Employee e = new Employee();
		e.setEname("宏老师");
		e.setSalary(20000);
		e.setAge(18);
		dao.save(e);
	}
	
	@Test
	public void test2(){
		List<Employee> employees = 
				dao.findAll();
		System.out.println(employees);
	}
	
	
	
	
	
	
	
	
	
}



