package ssh.day02;

public class JsonResultAction {
	private String name;
	private int age;
	private JsonResult jsonResult;
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
	public JsonResult getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String execute(){
		name = "Tom";
		age = 10;
		String[] names = {"Andy","Mac","John","Jerry"};
		jsonResult = new JsonResult(names);
		return "success";
	}
	
}







