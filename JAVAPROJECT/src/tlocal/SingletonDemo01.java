package tlocal;
/**
 * 单例模式(保证类的实例在内存中只有一份)
 * 1)属于对象的创建型模式(与对象创建有关)
 * 2)单例模式应用场景?
 * 2.1)池对象(字符串池,整数池,线程池,....)
 * 2.2)工具类
 * 2.3)....................
 * 单例模式设计:
 * 1)构造函数私有化
 * 2)类的内部构建对象
 * 3)类的外部通过类中的静态方法访问对象
 * 
 * 单例对象类型
 * 1)懒汉单例(何时需要何时创建):大对象(占用内存多),稀少用
 * 2)饿汉单例(类加载时创建):小对象(占用资源比较少),频繁用
 * @author adminitartor
 */
class Singleton01{//线程不安全的懒汉单例
	private Singleton01(){}
	private static Singleton01 instance;
	public static Singleton01 getInstance(){
		if(instance==null){
			instance=new Singleton01();
		}
		return instance;
	}//这个方法可能会存在线程安全问题(方法内部操作为非原子操作)
}
class Singleton02{//线程安全的懒汉单例
	private Singleton02(){}
	private static Singleton02 instance;
	synchronized public static Singleton02 getInstance(){
		if(instance==null){
			instance=new Singleton02();
		}
		return instance;
	}//线程安全了,性能降低了(每次只能有一个线程进入此方法获取对象)
}//如何改善这个类的性能.

class Singleton03{//线程安全的懒汉单例实现性能方法的改进
	private Singleton03(){}
	//volatile 保证可见,但不保证原子性
	//在双重判定场景下也会经常使用volatile关键字
	private static volatile Singleton03 instance;
    public static Singleton03 getInstance(){
    	if(instance==null){
    	 synchronized (Singleton03.class) {
    		if(instance==null){
    			instance=new Singleton03();
    		}
		 }//有些线程就不会再进入这个代码块了
    	}
		return instance;
	}
    //public static void display(){}
}
class Singleton04{
	//不存在线程安全问题的饿汉式单例(类加载时就构建对象)
	private Singleton04(){}
	private static final Singleton04 instance=
			new Singleton04();
	public static Singleton04 getInstance() {
		return instance;
	}
	//int array[]=new int[256];//256*4
    //public static void display(){}//Singleton04.display()
    //public void show(){}//Singleton04.getInstance().show();
};
class Singleton05{//改进版的饿汉单例(懒加载延迟对象创建)
	private Singleton05(){}
	static class Inner{//Inner类加载时创建对象
		static Singleton05 instance=new Singleton05();
	}
	public static Singleton05 getInstance() {
		return Inner.instance;
	}
	//int array[]=new int[256];
	//public static void display(){}Singleton05.display()
	
}
//枚举
enum Singleton06{//未改良版的饿汉单例
	A; //此对象类加载时就会创建
	public static void display(){}
	public void show(){}//Singleton06.A.show();
}//不适合大对象

//线程内部单例如何实现?(借助ThreadLocal)
public class SingletonDemo01 {

	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new Thread(){
				public void run() {
					System.out.println(
							Singleton02.getInstance());
				};
			}.start();
		}
		
	}
}









