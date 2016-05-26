package com.weixin.util;

import java.util.Arrays;

/**
 * @author : Jay
 */
public class CheckUtil {

	public static final String token = "dxETBxjYX_7DeNwwyff9AEgajL2_Dt5JC2WHf6SJFD4MT1Igk3gzqjCTO_hz2NOfQVCGOjNx3JC0dpMW3cJ3iG9WbTuUfz7IJZSnc6SHSLG0oq2o6b7hTVxG0CLQwN_KSFGbABAJWX";

	public static boolean checkSignature(String signature, String timestamp,String nonce) {
		
		//String token = TokenThread.accessToken.getAccessToken();
		//System.out.println("------------token------------ " + token);
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
