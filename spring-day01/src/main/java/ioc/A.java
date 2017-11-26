package ioc;

public class A {
	private B b;
	
	public B getB() {
		return b;
	}
	public void setB(B b) {
		System.out.println("setB()");
		this.b = b;
	}
	public A(){
		System.out.println("A()");
	}
	public void execute(){
		
	}
}
