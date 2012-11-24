/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Md5PasswordEncoder.java 1.1 2011-4-6
 */
package com.boan.crm.groupmanage.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Encoded password by MD5, Copy form Spring Security3
 * @author XXX
 * @version 1.0.0
 */
public class Md5PasswordEncoder {

	private static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * Encoded password by MD5
	 * @param password
	 * @return Encoded password by MD5
	 */
	public static String encodePassword(String password) {
		return encodePassword(password, null);
	}

	/**
	 * Encoded password by MD5 with salt
	 * @param password
	 * @param salt
	 * @return Encoded password by MD5 with salt
	 */
	public static String encodePassword(String password, String salt) {
		String saltedPass = mergePasswordAndSalt(password, salt);
		MessageDigest messageDigest = getMessageDigest();

		byte[] digest;

		try {
			digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("UTF-8 not supported!");
		}

		return new String(encode(digest));
	}

	private static String mergePasswordAndSalt(String password, Object salt) {
		if (password == null) {
			password = "";
		}

		if (salt != null) {
			if ((salt.toString().lastIndexOf("{") != -1)
					|| (salt.toString().lastIndexOf("}") != -1)) {
				throw new IllegalArgumentException(
						"Cannot use { or } in salt.toString()");
			}
		}

		if ((salt == null) || "".equals(salt)) {
			return password;
		} else {
			return password + "{" + salt.toString() + "}";
		}
	}

	private static final MessageDigest getMessageDigest()
			throws IllegalArgumentException {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("No such algorithm [MD5]");
		}
	}

	private static char[] encode(byte[] bytes) {
		final int nBytes = bytes.length;
		char[] result = new char[2 * nBytes];

		int j = 0;
		for (int i = 0; i < nBytes; i++) {
			// Char for top 4 bits
			result[j++] = HEX[(0xF0 & bytes[i]) >>> 4];
			// Bottom 4
			result[j++] = HEX[(0x0F & bytes[i])];
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(Md5PasswordEncoder.encodePassword("1"));
		List<String> list = new ArrayList<String>();
		list.add("hongqi");
		list.add("yxn");
		list.add("zww");
		list.add("zzb");
		list.add("zyf");
		list.add("hongqi2");
		list.add("tongxin");
		list.add("query1");
		list.add("hubin");
		list.add("sss");
		list.add("22");
		list.add("chaoyang");
		list.add("hongqi1");
		list.add("ljn");
		list.add("chongqing");
		list.add("chongqing1");
		list.add("chongqing2");
		list.add("guangming");
		list.add("cbit");
		
		for(String name : list){
			System.out.println(name + ":" + Md5PasswordEncoder.encodePassword("123456", name));
		}
		//System.out.println(Md5PasswordEncoder.encodePassword("123456", "cbit"));
		System.out.println(Md5PasswordEncoder.encodePassword("123456", "123"));
	}
}
