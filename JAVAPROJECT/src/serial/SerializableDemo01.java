package serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;

class Student implements Serializable{

	private static final long serialVersionUID = -6878188780054330073L;
	private String name;
	private int age;
	private int weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//对象在序列化时调用(可用于加密)
	private void writeObject(ObjectOutputStream out) throws IOException{
		//类似加密
		age=age>>2;
		name=Base64.encodeBase64String(name.getBytes("utf-8"));
		//执行序列化
		out.defaultWriteObject();
	}
	//对象在反序列化时调用(可用于解密)
	private void readObject(ObjectInputStream in)
	throws Exception{
		in.defaultReadObject();
		age=age<<2;
		name=new String(Base64.decodeBase64(name.getBytes("utf-8")));
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
		
}
/**默认序列化是安全的吗?不安全,如何实现安全序列化?*/
public class SerializableDemo01 {
	public static void main(String[] args)throws Exception {
		 ObjectOutputStream out=
		 new ObjectOutputStream(
		 new FileOutputStream("f.txt"));
		 Student s1=new Student();
		 s1.setName("苍老师");
		 s1.setAge(16);
		 //对象序列化
		 out.writeObject(s1);
		 out.close();
		 
		 ObjectInputStream in=
			new ObjectInputStream(
		 new FileInputStream("f.txt"));
		 Object obj=in.readObject();
		 System.out.println(obj);
		 in.close();
	}

}







