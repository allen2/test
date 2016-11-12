package com.renren.ntc.sg.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.paoding.rose.web.Invocation;

public class AccessLogFilter {
	private AccessLogFilter() {

	}

	private static final AccessLogFilter ACCESS_LOG_FILTER = new AccessLogFilter();

	public static AccessLogFilter getInstance() {
		return ACCESS_LOG_FILTER;
	}
	public void filter(Invocation inv){
		try {
			HttpServletRequest request = inv.getRequest();
			if ("POST".equalsIgnoreCase(request.getMethod())
			        || "GET".equalsIgnoreCase(request.getMethod())) {
			    Map<String, String[]> params = request.getParameterMap();
			    if (params != null && params.size() > 0) {
			        StringBuilder buf = new StringBuilder();
			        for (Map.Entry<String, String[]> entry : params.entrySet()) {
			            String[] values = entry.getValue();
			            if (values == null) {
			                buf.append(entry.getKey());
			                buf.append('=');
			                buf.append('&');
			                continue;
			            }
			            for (String value : values) {
			                buf.append(entry.getKey());
			                buf.append('=');
			                buf.append(value);
			                buf.append('&');
			            }
			        }
			        request.setAttribute("POSTSTRING", buf.substring(0, buf.length() - 1).replaceAll("\r\n", ""));
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
