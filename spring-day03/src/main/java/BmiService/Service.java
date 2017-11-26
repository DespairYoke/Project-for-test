package BmiService;

public class Service {
	public String bmi(double height,double weight){
		String status="正常";
		double bmi=weight/height/height;
		if(bmi<19)
		{
			status="过轻";
		}
		if(bmi>25)
		{
			status="过重";
		}
		return status;
		
	}
}
