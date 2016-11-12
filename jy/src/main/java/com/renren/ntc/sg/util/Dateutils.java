package com.renren.ntc.sg.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dateutils {
	public static final String FORMAT_ALL = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat SDF = new SimpleDateFormat(FORMAT_ALL);
	public static final String FORMAT_DEFAULT = "yyyy-MM-dd";
	private static SimpleDateFormat DSDF = new SimpleDateFormat(FORMAT_DEFAULT);
	public static final String FORMAT_HM = "HH:mm";
	private static SimpleDateFormat HMSDF = new SimpleDateFormat(FORMAT_HM);
	
	public static final String FORMAT_ALL_CALENDAR = "yyyy年MM月dd日 HH:mm:ss";
	private static SimpleDateFormat FLCSDF = new SimpleDateFormat(FORMAT_ALL_CALENDAR);

	public static Date getDateByCondition(int date,int hour,int minute,int second,int millsend){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, date);
		now.set(Calendar.HOUR_OF_DAY, hour);
		now.set(Calendar.MINUTE, minute);
		now.set(Calendar.SECOND, second);
		now.set(Calendar.MILLISECOND, millsend);
		return now.getTime();
	}

	public static Date getDateByCondition(int hour){
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		now.add(Calendar.HOUR_OF_DAY, hour);
		return now.getTime();
	}

	public static Date setDateByCondition(int year,int month,int date,int hour,int minute,int second,int millsend){
		Calendar now = Calendar.getInstance();
		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, month);
		now.set(Calendar.DAY_OF_MONTH, date);
		now.set(Calendar.HOUR_OF_DAY, hour);
		now.set(Calendar.MINUTE, minute);
		now.set(Calendar.SECOND, second);
		now.set(Calendar.MILLISECOND, millsend);
		return now.getTime();
	}

	public static Date parseDate(String dateStr){
		Date date = null;
		try {
			date =  SDF.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static Date getAddDateByCondition(int date,int hour,int minute,int seconds){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, date);
		now.add(Calendar.HOUR_OF_DAY, hour);
		now.add(Calendar.MINUTE, minute);
		now.add(Calendar.SECOND, seconds);
		now.add(Calendar.MILLISECOND, 0);
		return now.getTime();
	}
	
	public static Date getAddDateByCondition(Date dateTime,int date,int hour,int minute,int seconds){
		Calendar now = Calendar.getInstance();
		now.setTime(dateTime);
		now.add(Calendar.DAY_OF_MONTH, date);
		now.add(Calendar.HOUR_OF_DAY, hour);
		now.add(Calendar.MINUTE, minute);
		now.add(Calendar.SECOND, seconds);
		now.add(Calendar.MILLISECOND, 0);
		return now.getTime();
	}

	public static String tranferDate2Str(Date date){
		if(date == null){
			return null;
		}
		return SDF.format(date);
	}

	public static String tranferHMDate2Str(Date date){
		if(date == null){
			return "";
		}
		return HMSDF.format(date);
	}

	public static String tranferDefaultDate2Str(Date date){
		if(date == null){
			return "";
		}
		return DSDF.format(date);
	}
	
	public static String tranferYMDDate2Str(Date date){
		if(date == null){
			return "";
		}
		return FLCSDF.format(date);
	}

	public static String getDateStrByCondition(String condition){
		if(StringUtils.isBlank(condition)){
			return "";
		}
		String[] dateStr = condition.split(":");
		if(dateStr == null ||  dateStr.length != 2){
			return "";
		}
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		now.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateStr[0]));
		now.set(Calendar.MINUTE, Integer.parseInt(dateStr[1]));
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		return tranferDate2Str(now.getTime());
	}
	public static Date transferToDatebyCondition(String condition){
		if(StringUtils.isBlank(condition)){
			return null;
		}
		String[] dateStr = condition.split(" ");
		String[] yMD = dateStr[0].split("-");
		Calendar now = Calendar.getInstance();
		String[] hMS = dateStr[1].split(":");
		now.set(Calendar.YEAR, Integer.parseInt(yMD[0]));
		now.set(Calendar.MONTH, Integer.parseInt(yMD[1]));
		now.set(Calendar.HOUR_OF_DAY, Integer.parseInt(yMD[2]));
		now.set(Calendar.MINUTE, Integer.parseInt(hMS[0]));
		now.set(Calendar.SECOND, Integer.parseInt(hMS[1]));
		now.set(Calendar.MILLISECOND, Integer.parseInt(hMS[2]));
		return now.getTime();
	}

    public static Date getDateByCondition(int date, int hour, int minute, int seconds) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, date);
        now.set(Calendar.HOUR_OF_DAY, hour);
        now.set(Calendar.MINUTE, minute);
        now.set(Calendar.SECOND, seconds);
        now.set(Calendar.MILLISECOND, 59);
        return now.getTime();
    }

	public static long getTodayrest() {
		long current = System.currentTimeMillis();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		long rest = c.getTime().getTime() - current;
		return rest;
	}



	/**
	 * get now time before 5 minute
	 */
	public static Date getBefore5minute(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MINUTE, -5);
		return now.getTime();
	}
	/**
	 * 08:00 AM
	 * 10:00 PM
	 * @return
	 */
	public static String getHMDateBycondition(String timeStr){
		if(StringUtils.isBlank(timeStr)){
			return "";
		}
		String[] timeArr = timeStr.split(" ");
		if(timeArr == null || timeArr.length != 2){
			return "";
		}
		if(!timeArr[1].equalsIgnoreCase("am") && !timeArr[1].equalsIgnoreCase("pm")){
			return "";
		}else if (timeArr[1].equalsIgnoreCase("pm")) {
			String hmTimeStr = timeArr[0];
			String[] hmArr= hmTimeStr.split(":");
			if(hmArr == null || hmArr.length !=2){
				return "";
			}
			int hour = Integer.parseInt(hmArr[0]);
			hour += 12;
			String hmDate = String.valueOf(hour) + ":" + hmArr[1];
			return hmDate;
		}else {
			String[] hmArr= timeArr[0].split(":");
			if(hmArr == null || hmArr.length !=2){
				return "";
			}
			return timeArr[0];
		}
	}
	public static String addHMFormatDateByCondition(String timeStr,int hour,int minute){
		if(StringUtils.isBlank(timeStr)){
			return "";
		}
		String[] timeArr = timeStr.split(":");
		if(timeArr == null || timeArr.length != 2){
			return "";
		}
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArr[0]) + hour);
		now.set(Calendar.MINUTE, Integer.parseInt(timeArr[1]) + minute);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		return tranferDate2Str(now.getTime());

	}

	public static boolean isBetweenDate(Date beginDate,Date endDate,Date nowDate){
		if(nowDate.getTime() >= beginDate.getTime() && nowDate.getTime() <= endDate.getTime()){
			return true;
		}
		return false;
	}

	/**
	 * 获取相对于今天的指定日期
	 * 负数: 今天之前
	 * 正数: 未来日期
	 * @param num
	 * @return yyyy-MM-dd
	 */
	public static String getDay(int num){
		Calendar   cal   =   Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		return DSDF.format(cal.getTime());
	}
	/**
	 * 获取相对于今天的指定日期
	 * 负数: 今天之前
	 * 正数: 未来日期
	 * @param num
	 * @return yyyy-MM-dd
	 */
	public static String getDayBySecond(int num,Date date){
		Calendar   cal   =   Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, num);
		return SDF.format(cal.getTime());
	}



	public static void main(String[] args) {
		Date now = setDateByCondition(2015, 3, 23, 0, 0, 0, 0);
		System.out.println(tranferDate2Str(now));
		System.out.println(dayForWeek(Dateutils.parseDate("2015-05-18 00:00:00")));
	}
	
	public static int dayForWeek(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}  

}