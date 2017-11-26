package ioc;

public class Restaurant {
	private Waiter wt;

	
	public Restaurant(Waiter wt) {
		System.out.println("waiter()");
		this.wt = wt;
	}


	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}


}
