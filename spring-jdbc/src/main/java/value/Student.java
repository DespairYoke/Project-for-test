package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	private String name;
	private int age;
	
	private List<String> interest;
	private Set<String> city;
	private Map<String,Double> score;
	private Properties db;
	
	public Student() {
		System.out.println("Student()");
	}

	public void setScore(Map<String, Double> score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getInterest() {
		return interest;
	}

	public Set<String> getCity() {
		return city;
	}

	public Map<String, Double> getScore() {
		return score;
	}

	public Properties getDb() {
		return db;
	}

	public void setDb(Properties db) {
		this.db = db;
	}

	public void setCity(Set<String> city) {
		this.city = city;
	}

	public void setInterest(List<String> interest) {
		this.interest = interest;
	}

	/**
	 * 容器会调用此方法来注入基本类型的值
	 */
	public void setName(String name) {
		System.out.println("setName() " + name);
		this.name = name;
	}
	
	public void setAge(int age) {
		System.out.println("setAge() " + age);
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", interest=" + interest + ", city=" + city + ", score="
				+ score + ", db=" + db + "]";
	}
	
	
	
	
}
