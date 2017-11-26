package ssh.day01;

public class MsgAction {
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	/**
	 * 将数据从控制器传递到 JSP 页面
	 */
	public String execute(){
		message = "Hello World!";
		return "success";
	}
}
