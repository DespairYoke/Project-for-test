package digest;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

public class MD5Demo02 {

	public static void main(String[] args)
	throws Exception{//MD5,SHA
		//77abeecc1d175ba4df89235f64ebbae0
		String password="123456";
		String email="qilei@tedu.cn";//salt(盐值)
		String content=password+email;
		MessageDigest mDigest=
		MessageDigest.getInstance("MD5");
		byte[] buf=mDigest.digest(content.getBytes());
		//System.out.println(buf.length);//16*8=128位
		//System.out.println(Arrays.toString(buf));
		StringBuilder sb=new StringBuilder();
		for(byte b:buf){
			String sHex=Integer.toHexString(b&0xff);
			if(sHex.length()==1){
				sHex="0"+sHex;
			}
			//System.out.println(sHex);
			sb.append(sHex);
		}
		System.out.println(sb.toString());//32bit
		
		String randomStr=
				UUID.randomUUID().toString();
		System.out.println(randomStr);
		
	}
}
