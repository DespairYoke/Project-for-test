package digest;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Demo04 {

	public static void main(String[] args) {
		String s1="123456";
		String s2=DigestUtils.md5Hex(s1);
		System.out.println(s2);
		String s3=DigestUtils.sha1Hex(s2);
		System.out.println(s3);
		String s4=DigestUtils.md5Hex(s2);
		System.out.println(s4);
	}
}
