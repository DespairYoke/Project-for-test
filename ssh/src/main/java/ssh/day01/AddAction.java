package ssh.day01;

public class AddAction {
	
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	//利用JavaBean打包接收表单参数
	public String add(){
		System.out.println(product); 
		return "success";
	}

}
