package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.LoginService;

public class TestCase {
	@Test
	public void test1() throws SQLException{
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"spring-mvc.xml");
		/*	
		 * DataSource是一个接口。
		 * BasicDataSource是DataSource的实现类。
		 */
		DataSource ds = ac.getBean("ds",
				DataSource.class);
		System.out.println(ds.getConnection());
		
	}
	
	@Test
	public void test2() throws SQLException{
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"spring-mvc.xml");
		UserDAO dao = 
				ac.getBean("userDAO",UserDAO.class);
		User user = dao.findByUsername("yangming");
		System.out.println(user);
		
	}
	
	
	@Test
	public void test3() throws SQLException{
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"spring-mvc.xml");
		LoginService service = 
				ac.getBean("loginService",LoginService.class);
		User user = service.checkLogin("King","1234");
		System.out.println(user);
		
	}
	
	
}
