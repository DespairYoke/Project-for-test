package ssh.day01;

import java.util.ArrayList;
import java.util.List;

public class ListAction {
	private List<Product> list=
			new ArrayList<Product>();
	
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	
	public String execute(){
		list.add(new Product(5, "北京", 5.6));
		list.add(new Product(6, "上海", 6.6));
		list.add(new Product(7, "广州", 7.6));
		list.add(new Product(8, "深圳", 8.6));
		list.add(new Product(9, "杭州", 9.6));
		return "success";
	}
}
