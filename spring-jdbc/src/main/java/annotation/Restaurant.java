package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Restaurant {
	
	@Autowired
	@Qualifier("wt")
	private Waiter wt;

	
	public Restaurant() {
		System.out.println("restaurant()");
	}
	
	public Waiter getWt() {
		return wt;
	}
	/*@Autowired
	public void setWt(@Qualifier("wt") Waiter wt) {
		System.out.println("setWt()"+wt);
		this.wt = wt;
	}
*/
	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
}
