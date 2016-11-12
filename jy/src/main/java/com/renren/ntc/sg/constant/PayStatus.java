package com.renren.ntc.sg.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public enum PayStatus {
	CASH("cash"),WX_NETIVE("wx_native"),ALI_NATIVE("ali_native");
	private String desc;
	private static final Map<String, String> payStatusMap = new HashMap<String, String>();  
	  
    static {  
        for (PayStatus s : EnumSet.allOf(PayStatus.class)) {  
        	payStatusMap.put(s.getDesc(), ""); 
        }  
    }
	private PayStatus(String desc){
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static boolean containsKey(String payStatus){
		return payStatusMap.containsKey(payStatus);
	}
}
