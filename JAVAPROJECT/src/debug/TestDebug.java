package debug;
public class TestDebug {//debug 调试(f6,f5,f7,f8)
	static int get(){
		int a=10;
		try{
			return a;
		}finally{
			a++;
		}
	}
	public static void main(String[] args) {
		System.out.println("===main====");
		int result=get();
		System.out.println(result);//10 or 11
	}
}
