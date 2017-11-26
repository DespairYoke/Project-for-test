package value;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import annotation.Restaurant;

@Configuration
@ComponentScan("annotation")
public class syb {
	@Autowired
	Restaurant rt;
	public  void play() {
		System.out.println(444);
		System.out.println(rt);
	}
}
