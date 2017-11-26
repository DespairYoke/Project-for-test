package tlocal;

import com.sun.swing.internal.plaf.synth.resources.synth;

class Rect{}
class MyClass{}
class WorkThread03 extends Thread{
	private static Rect instance;
	@Override
	public void run() {
		//try{Thread.sleep(5000);}catch(Exception e){}
		instance=new Rect();
		synchronized (WorkThread03.class) {
			WorkThread03.class.notify();
		}
	}
	//静态方法默认使用的对象锁为方法所在类的类对象WorkThread03.class
	public synchronized static Rect getRect(){
		while(instance==null){
			try{WorkThread03.class.wait();}
			catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);}
		}
		return instance;
	}//SCJP,OCJP
}

public class CommunicationDemo03 {
    public static void main(String[] args) {
    	WorkThread03 w=new WorkThread03();
    	w.start();
    	System.out.println(w.getRect());
	}
}
