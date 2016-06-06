package com.weixin.util;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Jay
 */
public class CheckUtil {

	private static final Logger log = LoggerFactory.getLogger(CheckUtil.class);
	
	public static boolean checkSignature(String signature, String timestamp,String nonce) {

		String token = TokenThread.accessToken.getAccessToken();
		
		log.info("token = {}",token);
		
		String[] arr = new String[] { token, timestamp, nonce };

		// 排序
		Arrays.sort(arr);

		// 生成字符
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		// sha1 加密
		EncryptUtil sha1 = new EncryptUtil();
		String str = sha1.Encrypt(sb.toString(), "SHA-1") ;
		System.out.println(str);
		return signature.equals(str);

	}

}
