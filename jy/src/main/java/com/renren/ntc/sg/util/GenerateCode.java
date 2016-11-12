package com.renren.ntc.sg.util;


/**
 * 生成4位的收货码
 * @author chunhai.li
 *
 */
public class GenerateCode {
	public static String getReceiveCodeByCount(int count){
		 StringBuilder receiveCodeStr = new StringBuilder();
		  for (int i = 0; i < count; i++) {
		   int code = (int) (Math.random() * 10);
		   receiveCodeStr.append(code);
		  }
		  return receiveCodeStr.toString();
	}
	public static void main(String[] args) {
		while(true){
		System.out.println(getReceiveCodeByCount(4));
		}
	}
}
