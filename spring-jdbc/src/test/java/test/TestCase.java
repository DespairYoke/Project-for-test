package test;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import value.SpelBean;
import value.Student;

public class TestCase {
	
	@Test
	//测试 读取db.properties文件
	public void test5(){
		String config = "ds.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Properties props = 
				ac.getBean("db",Properties.class);
		System.out.println(props);
	}
	
	@Test
	//测试 数据库连接池
	public void test6() throws SQLException{
		String config = "ds.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		BasicDataSource ds = 
				ac.getBean("ds",
						BasicDataSource.class);
		System.out.println(ds.getConnection());
	}
	
	
	
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
	
	@Test
	//测试 Spring表达式
	public void test4(){
		String config = "value.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		SpelBean sb1 = 
				ac.getBean("sb1",SpelBean.class);
		System.out.println(sb1);
		
	}
}








