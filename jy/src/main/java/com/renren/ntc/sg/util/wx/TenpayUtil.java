package com.renren.ntc.sg.util.wx;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TenpayUtil {
	
	private static Object Server;
	private static String QRfromGoogle;


	public static String toString(Object obj) {
		if(obj == null)
			return "";
		
		return obj.toString();
	}
	


	public static int toInt(Object obj) {
		int a = 0;
		try {
			if (obj != null)
				a = Integer.parseInt(obj.toString());
		} catch (Exception e) {

		}
		return a;
	}
	

	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	

	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String strDate = formatter.format(date);
		return strDate;
	}
	
	/**
	 * ȡ��һ��ָ�����ȴ�С�����������.
	 * 
	 * @param length
	 *            int �趨��ȡ�������ĳ��ȡ�lengthС��11
	 * @return int ������ɵ������
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	/**
	 * ��ȡ�����ַ�
	 * @param request
	 * @param response
	 * @return String
	 */

	public static String getCharacterEncoding(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(null == request || null == response) {
			return "gbk";
		}
		
		String enc = request.getCharacterEncoding();
		if(null == enc || "".equals(enc)) {
			enc = response.getCharacterEncoding();
		}
		
		if(null == enc || "".equals(enc)) {
			enc = "gbk";
		}
		
		return enc;
	}
	
	public  static String URLencode(String content){
		
		String URLencode;
		
		URLencode= replace(Server.equals(content), "+", "%20");
		
		return URLencode;
	}
	private static String replace(boolean equals, String string, String string2) {
		
		return null;
	}


	public static long getUnixTime(Date date) {
		if( null == date ) {
			return 0;
		}
		
		return date.getTime()/1000;
	}
	
	 public static String QRfromGoogle(String chl)
	    {
	        int widhtHeight = 300;
	        String EC_level = "L";
	        int margin = 0;
	        String QRfromGoogle;
	        chl = URLencode(chl);
	        
	        QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;
	       
	        return QRfromGoogle;
	    }


	public static String date2String(Date date, String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(date);
	}
	
}
	
	









