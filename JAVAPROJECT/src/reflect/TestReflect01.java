package reflect;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
/**
 * @Retention用于定义注解何时有效
 * @Target用于定义注解应用在什么元素上
 * @author adminitartor
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Autowired{}//Autowired.class
class Student{
	@Autowired
	private int age;
	private int weight;
	@Override
	public String toString() {
		return "Student [age=" + age + ", weight=" + weight + "]";
	}
}
public class TestReflect01 {//spring
    public static void main(String[] args) throws Exception{
		Student s1=new Student();//静态过程
		//Class<?> c0=Class.forName("reflect.Student");
		//c0.getDeclaredMethod(name, parameterTypes)
		//获取类对象
		Class<?> c1=s1.getClass();
		//获得Student类中所有属性.
		Field fs[]=c1.getDeclaredFields();
		for(Field f:fs){
			//判定f属性是否使用了Autowired注解修饰
			if(f.isAnnotationPresent(Autowired.class)){
				//设置私有属性可访问
				f.setAccessible(true);
				//为s1对象的f属性赋值
				f.set(s1, 18);
			}
		}
		System.out.println(s1);
	}
}





