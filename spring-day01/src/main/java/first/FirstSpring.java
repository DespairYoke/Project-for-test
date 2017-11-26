package first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
	public static void main(String[] args) {
		String config="applicationContext.xml";
		ApplicationContext ac= new ClassPathXmlApplicationContext(config);
		Apple a=(Apple) ac.getBean("apple",Apple.class);
	}
}
