package com.renren.ntc.sg.util;

import java.sql.Timestamp;
import java.util.UUID;

public class IdGenerator {

	  private static final int[] codex = { 2, 3, 5, 6, 8, 9, 19, 11, 12, 14, 15, 17, 18 };

	  public static String getGid(){
	    StringBuilder sb = new StringBuilder(44);
	    long time = System.currentTimeMillis();
	    String ts = new Timestamp(time).toString();

	    for (int idx : codex){
	      sb.append(ts.charAt(idx));
	    }
	   String uuid =  UUID.randomUUID().toString().replace("-", "").toString();
	   sb.append(uuid);
	   System.out.println(uuid);
	    return sb.toString().replace(".", "");
	  }
	  
	  public static String getUserToken(String phone,long userId){
		  StringBuffer ramdomUserTokenBuffer = new StringBuffer();
		ramdomUserTokenBuffer.append("mm").append(phone)
							 .append(UUID.randomUUID().toString()
							 .replace("-", ""))
							 .append("_").append(userId);
		  return MD5Utils.MD5(ramdomUserTokenBuffer.toString());
	  }
	  
	  public static String getDefaultAppPwd(){
		  return MD5Utils.MD5("mmuser"+UUID.randomUUID().toString().replace("-", ""));
	  }
	  public static void main(String[] args) {
		System.out.println(new IdGenerator().getGid());
	}
}
