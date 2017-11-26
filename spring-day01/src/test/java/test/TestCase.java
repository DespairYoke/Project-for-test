package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.ExampleBean;
import basic.MessageBean;
import basic.ScopeBean;
import ioc.Restaurant;

public class TestCase {

	@Test
	public void test1(){
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	/*	ExampleBean eb1=ac.getBean("eb1",ExampleBean.class);
		ExampleBean eb2=ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1==eb2);*/
		MessageBean mb=ac.getBean("mb1",MessageBean.class);
	}
	@Test
	public void test3(){
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	/*	ExampleBean eb1=ac.getBean("eb1",ExampleBean.class);
		ExampleBean eb2=ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1==eb2);*/
		/*ScopeBean sb=ac.getBean("sb1",MessageBean.class);*/
	}
	@Test
	public void test4(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	/*	ExampleBean eb1=ac.getBean("eb1",ExampleBean.class);
		ExampleBean eb2=ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1==eb2);*/
		/*ScopeBean sb=ac.getBean("sb1",MessageBean.class);*/
		Restaurant r=ac.getBean("a",Restaurant.class);
	}
}
