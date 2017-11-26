package digest;
//commons.apache.org 官网下载codec
import org.apache.commons.codec.binary.Base64;
public class Base64Demo01 {
	public static void main(String[] args) {
		String s1="helloworld";
		//加密
		byte[] buf=Base64.encodeBase64(s1.getBytes());
		String s2=new String(buf);
		System.out.println(s2);
		//解密
		buf=Base64.decodeBase64(buf);
		String s3=new String(buf);
		System.out.println(s3);
	}
}
