package tlocal;
class WorkThread extends Thread{
	private volatile boolean isExit=false;
	//private static String LOCK="LOCK";
	@Override
	public void run() {
		while(true){
			//synchronized (LOCK) {
				if(isExit){
					 System.out.println("work thread exit");
					 break;
				}
			//}
			
		}
	}
	public void setExit(boolean isExit) {
		//synchronized (LOCK) {
			this.isExit = isExit;
		//}
	}
}
public class VolatileDemo01 {
	public static void main(String[] args)
	throws Exception{
		WorkThread w=new WorkThread();
		w.start();
		Thread.sleep(200);
		w.setExit(true);
	}
}
