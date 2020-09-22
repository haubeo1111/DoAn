package com.example.demo.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	public static String md5(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            byte byteData[] = md.digest();
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return  sb.toString();
        } catch (Exception ex) {
            return "";
        }
    }
	public static String convertByteToHex1(byte[] data) {
		  BigInteger number = new BigInteger(1, data);
		  String hashtext = number.toString(16);
		  // Now we need to zero pad it if you actually want the full 32 chars.
		  while (hashtext.length() < 32) {
		    hashtext = "0" + hashtext;
		  }
		  return hashtext;
		}
		public static String convertByteToHex2(byte[] data) {
		  StringBuffer sb = new StringBuffer();
		  for (int i = 0; i < data.length; i++) {
		    sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
		  }
		  return sb.toString();
		}
		public static String convertByteToHex3(byte[] data) {
		  StringBuffer hexString = new StringBuffer();
		  for (int i = 0; i < data.length; i++) {
		    String hex = Integer.toHexString(0xff & data[i]);
		    if (hex.length() == 1)
		      hexString.append('0');
		    hexString.append(hex);
		  }
		  return hexString.toString();
		}
	public static String getMD5(String input) {
		  try {
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    byte[] messageDigest = md.digest(input.getBytes());
		    return convertByteToHex1(messageDigest);
		  } catch (NoSuchAlgorithmException e) {
		    throw new RuntimeException(e);
		  }
	}
	public static String getMD5(File file) {
		  MessageDigest md;
		  try {
		    md = MessageDigest.getInstance("MD5");
		    FileInputStream fis = new FileInputStream(file);
		    byte[] dataBytes = new byte[1024];
		    int nread = 0;
		    while ((nread = fis.read(dataBytes)) != -1) {
		      md.update(dataBytes, 0, nread);
		    }
		    byte[] byteData = md.digest();
		    fis.close();
		    return convertByteToHex1(byteData);
		  } catch (NoSuchAlgorithmException | IOException e) {
		    e.printStackTrace();
		    throw new RuntimeException(e);
		  }
	}

	public static String md51(String str){
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1,digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String md52(String str){
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1,digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Md5.md5("123456"));;
	}
}
