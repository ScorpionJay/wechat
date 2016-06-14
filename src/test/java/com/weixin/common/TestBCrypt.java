package com.weixin.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author jay
 * @since 2016年6月14日
 */
public class TestBCrypt {
	public static void main(String[] args) {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		String s = b.encode("jay123");
		System.out.println(s);
		
		System.out.println(b.matches( "aaa","$2a$10$7ynjslYQr9AAv9N4cVtjNuc7vAP7wS.WKrMQWq9kGSXh0Uyvv4NM."));
	}
}
