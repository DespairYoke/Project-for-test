package tlocal;

import com.sun.org.apache.xpath.internal.axes.WalkingIterator;
import com.sun.swing.internal.plaf.synth.resources.synth;

/**
 * 线程同步:多线程并发执行时在共享数据集的互斥与协作
 * 1)互斥:多线程在共享数据集上排队执行
 * a)同步代码块synchronized(同步锁){}
 * b)同步方法
 * b.1) public synchronized void method1(){}
 * b.2) public synchronized static void method2(){}
 * c)ReentrantLock (JDK1.5)
 * 2)协作:多线程在共享数据集上的通讯
 * a)构建于互斥基础之上
 * b)在同步代码块或同步方法中借助wait,notify,notifyall方法执行通讯
 * wait:表示等待,调用此方法的线程会阻塞,同时释放锁
 * notify/notifyall:表示唤醒或通知正在处于wait状态且具备相同锁对象
 * 的线程.
 * 用法:
 * 1)wait,notify,notifyall必须用在同步代码块或同步方法中
 * 2)wait,notify,notifyall必须由对象锁调用
 */
public class CommunicationDemo01 {
	static  String content;
	public  static void main(String[] args) {
		Thread t=new Thread(){
			@Override
			public void run() {
				content="helloworld";
				//通知具备相同锁并处于阻塞状态的对象
				synchronized (Object.class) {
					Object.class.notifyAll();
				}
			}
		};
		t.start();
		
		synchronized (Object.class) {
			while(content==null){
				try{Object.class.wait();}
				catch(Exception e){}
			}
		}
	
		System.out.println(content.toUpperCase());
	}
}
