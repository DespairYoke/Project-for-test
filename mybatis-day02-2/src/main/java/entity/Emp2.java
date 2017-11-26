package entity;

public class Emp2 {
	private int empNo;
	private String name;
	private double salary;
	private int age;
	
	@Override
	public String toString() {
		return "Emp2 [empNo=" + empNo + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
