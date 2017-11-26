package tlocal;

import java.text.SimpleDateFormat;
class DateFormatUtil{
private static  volatile ThreadLocal<SimpleDateFormat> td
=new ThreadLocal<SimpleDateFormat>();
// private static SimpleDateFormat sdf=new SimpleDateFormat(pattern)
public static SimpleDateFormat getDateFormat(){
	//1.从当前线程获取对象
	SimpleDateFormat sdf=td.get();
	//2.当前线程没有,则创建,然后绑定到当前线程
	if(sdf==null){
		//map.put(key,value)
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		td.set(sdf);//绑定
	}
	//3.直接返回SimpleDateFormat对象
	return sdf;
}
public static void remove(){
	td.remove();
}
}
public class ThreadLocalDemo01 {
    public static void main(String[] args) {
	   SimpleDateFormat sdf1=DateFormatUtil.getDateFormat();
	   SimpleDateFormat sdf2=DateFormatUtil.getDateFormat();
	   System.out.println("sdf1="+sdf1);
	   System.out.println("sdf2="+sdf2);
	   //DateFormatUtil.remove();
	   new Thread(){
		   public void run() {
			   SimpleDateFormat sdf3=
			   DateFormatUtil.getDateFormat();
			   SimpleDateFormat sdf4=
			   DateFormatUtil.getDateFormat();
			   System.out.println("sdf3="+sdf3);
			   System.out.println("sdf4="+sdf4);
			   System.out.println(sdf4==sdf3);
			   System.out.println(sdf1==sdf3);
			   System.out.println(sdf1==sdf2);
		   };
	   }.start();
	   while(true){}
    }
}
/**HashSet
1)hashCode 不同直接存储
2)hashCode 相同,equals 也相同则认为是同一个对象,此对象不存储
3)hashCode 相同,再调用equals方法,equals 比较不同则存储

ArrayList存储结构:底层存储是数组,线性结构.
HashMap存储结构:数组+链表+红黑树
ConcurrentHashMap(1.8之前分段加锁,1.8之后红黑树)
*/















