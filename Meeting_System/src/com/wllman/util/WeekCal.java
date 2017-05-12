package com.wllman.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class WeekCal {

	public static List<String> mondayToSunday(String date) throws ParseException {

		List<String> week = new ArrayList<String>();
		Date now = new Date();
	  
		//Date time = new Date(now.getYear(), now.getMonth(), now.getDate());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		
		 Date  time =  sdf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		System.out.println("dayWeek:" + dayWeek);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		//System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		String imptimeBegin = sdf.format(cal.getTime());	
	    week.add(imptimeBegin);
		for (int i = 0; i < 6; i++) {
			cal.add(Calendar.DATE, 1);
//			cal.set(Calendar.HOUR, 0);
//			cal.set(Calendar.MINUTE, 0);
//			cal.set(Calendar.SECOND, 0);
			imptimeBegin = sdf.format(cal.getTime());
			//Date mondayDate = cal.getTime();
			week.add(imptimeBegin);
			System.out.println(imptimeBegin);
		}

		return week;

	}

	

}
