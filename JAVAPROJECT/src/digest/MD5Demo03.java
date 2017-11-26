package digest;

import java.security.MessageDigest;
//此API在eclipse中可能不能直接使用
//假如要使用可以在项目的buildpath中添加访问规则
import sun.misc.BASE64Encoder;
public class MD5Demo03 {
	public static void main(String[] args)
	throws Exception{
		String password="123456";
		//获得摘要对象
		MessageDigest mDigest=
		MessageDigest.getInstance("MD5");
		//获得字符串的摘要信息
		byte[] result=
		mDigest.digest(password.getBytes("utf-8"));
		//对摘要信息再次进行编码进制转换
		BASE64Encoder encoder=new BASE64Encoder();
		String s=encoder.encode(result);
		System.out.println(s);//4QrcOUm6Wau+VuBX8g+IPg==
	}
}
