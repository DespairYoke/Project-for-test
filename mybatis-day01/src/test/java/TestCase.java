import java.util.List;

import javax.management.MXBean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.Mapper;
import entity.Employee;

public class TestCase {
	SqlSession ss;
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("sqlMapConfig.xml"));
		 ss=ssf.openSession();
	}
	@Test
	public void Test1(){
		Employee e=new Employee();
		e.setEname("苏奕");
		e.setAge(22);
		e.setSalary(1000);
		Mapper dao=ss.getMapper(Mapper.class);
		dao.save(e);
		ss.commit();
		ss.close();
	}
	@Test
	public void Test2(){
		List list=ss.selectList("test.findAll");
		System.out.println(list);
	}
	@Test
	public void Test3(){
		Mapper dao=ss.getMapper(Mapper.class);
		List list=dao.findOne(74);
		System.out.println(list);
	}
	@Test
	public void Test4(){
		String str="?One?";
		System.out.println(str.toUpperCase().trim());
	}
}
