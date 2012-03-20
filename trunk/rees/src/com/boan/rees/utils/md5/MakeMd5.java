package com.boan.rees.utils.md5;

/**
 * 安全加密类(MD5)！
 * 
 * @author XXX
 * @createDate 2005-2-21
 * @version 1.0.0.0 Changed History:
 * 
 */
import java.security.*;
import java.security.spec.*;

public class MakeMd5 {
	
	
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// MakeMd5 aa = new MakeMd5();
		System.out.println(MakeMd5.MD5("password"));
		System.out.println("5f4dcc3b5aa765d61d8327deb882cf99");
	}
}