package ssh.day01;

import java.io.Serializable;

public class Product implements Serializable{

	private Integer age;
	private String address;
	private Double price;
	
	public Product() {
	}

	public Product(Integer age, String address, Double price) {
		super();
		this.age = age;
		this.address = address;
		this.price = price;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [age=" + age + ", address=" + address + ", price=" + price + "]";
	}
	
	
}
