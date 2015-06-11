package com.shin.board.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA256 암호화 클래스
 */
public class CEncrypt {
	MessageDigest md;
	String strSRCData = "";
	String strENCData = "";
	
	public CEncrypt() {
	}
	
	public CEncrypt(String strData) {
		this.encrypt(strData);
	}
	
	public void encrypt(String str) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
			strENCData = SHA.toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		strSRCData = str;
	}
	
	public String getEncryptData() {
		return strENCData;
	}
	
	public String getSourceData() {
		return strSRCData;
	}
	
	public boolean equal(String strData) {
		if (strData.equals(strENCData)) return true;
		return false;
	}
}
