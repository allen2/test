package com.renren.ntc.sg.util;

import java.util.Date;

import com.renren.ntc.sg.jredis.JRedisUtil;
import com.renren.ntc.sg.service.LoggerUtils;

public class CleanGetCashRedis {
	public static void main(String[] args) {
		String key = "gc_"+10033+"_"+Dateutils.tranferDefaultDate2Str(new Date());
		Long result = JRedisUtil.getInstance().del(key);
		LoggerUtils.getInstance().log(String.format("redis del key =%s,result=%d", key,result));
	}
}
