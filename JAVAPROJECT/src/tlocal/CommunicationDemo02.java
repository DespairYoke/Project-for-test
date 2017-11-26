package tlocal;


class Circle{}
class WorkThread02 extends Thread{
	private Circle circle;
	@Override
	public void run() {
		circle=new Circle();
		synchronized (WorkThread02.class) {//Class
			WorkThread02.class.notifyAll();
		}
	}
	public Circle getCircle(){
		synchronized (WorkThread02.class) {
			while(circle==null)
			try{WorkThread02.class.wait();}
			catch(Exception e){}
		}
		return circle;
	}
}
public class CommunicationDemo02 {
    public static void main(String[] args) {
    	WorkThread02 w=new WorkThread02();
    	w.start();
    //修改WorkThread02中代码保证如下语句的输出不为null
    	System.out.println(w.getCircle());
    	System.out.println(w.getCircle());
    	new Thread(){
    		public void run() {
    			System.out.println(w.getCircle());
    		};
    	}.start();
		
	}
}
