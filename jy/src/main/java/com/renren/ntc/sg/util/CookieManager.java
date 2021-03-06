package com.renren.ntc.sg.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie管理类
 * @author yunlong.bai@opi-corp.com
 *
 */


public class CookieManager {
	private static CookieManager instance;

	public static CookieManager getInstance() {
		if (instance == null)
			synchronized (CookieManager.class) {
				if (instance == null)
					instance = new CookieManager();
			}

		return instance;
	}
	public String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0)
			return null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(key))
				return cookies[i].getValue();
		}
		return null;
	}

	public void saveCookie(HttpServletResponse response, String key,
			String value) {
		this.saveCookie(response, key, value, -1,"/") ;
	}
	public void saveCookie(HttpServletResponse response, String key,
			String value,String path) {
		this.saveCookie(response, key, value, -1,path) ;
	}
	public void saveCookie(HttpServletResponse response, String key,
			String value,int second,String path) {
		Cookie cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setMaxAge(second);
        cookie.setDomain(Constants.DOMAIN);
        response.addCookie(cookie);
        cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setMaxAge(second);
        cookie.setDomain(Constants.DOMAIN2);
        response.addCookie(cookie);

        cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setMaxAge(second);
        cookie.setDomain(Constants.DOMAIN3);
        response.addCookie(cookie);

        cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setMaxAge(second);
        cookie.setDomain(Constants.DOMAIN4);
        response.addCookie(cookie);

		cookie = new Cookie(key, value);
		cookie.setPath(path);
		cookie.setMaxAge(second);
		cookie.setDomain(Constants.DOMAIN5);
		response.addCookie(cookie);
	}
	public void saveCookie(HttpServletResponse response, String key,
			String value,int second,String path, String domain) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath(path);
		cookie.setMaxAge(second);
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}	
	public void clearCookie(HttpServletResponse response, String key,
			int second,String path){
		Cookie cookie = new Cookie(key,null);
		cookie.setPath(path);
		cookie.setMaxAge(second);
		cookie.setDomain(Constants.DOMAIN);
		response.addCookie(cookie) ;
	}
	public void clearCookie(HttpServletResponse response, String key,
			int second,String path, String domain){
		if(key.equals("xng")){
			try{
				throw new Exception() ;
			}catch(Exception e){
				e.printStackTrace(System.out) ;
			}
		}
		Cookie cookie = new Cookie(key,null);
		cookie.setPath(path);
		cookie.setMaxAge(second);
		cookie.setDomain(domain);
		response.addCookie(cookie) ;
	}	

}
