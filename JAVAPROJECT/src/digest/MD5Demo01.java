package digest;
import java.security.MessageDigest;
import java.util.Arrays;

public class MD5Demo01 {

	public static void main(String[] args)
	throws Exception{//MD5,SHA
		String password="123456";
		//e10adc3949ba59abbe56e057f20f883e
		//e10adc3949ba59abbe56e057f20f883e
		//e10adc3949ba59abbe56e057f20f883e
		MessageDigest mDigest=
		MessageDigest.getInstance("MD5");
		byte[] buf=mDigest.digest(password.getBytes());
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
	}
}
