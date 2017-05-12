package com.wllman.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	public static String timeOffset(String fromDate,String toDate){
		String timeoffset = null;
		if(fromDate.equals("0")){
			fromDate = "00:00";
		}
		DateFormat df = new SimpleDateFormat("HH:mm");
		try {
			  Date ToDate = df.parse(toDate);
			  Date FromDate = df.parse(fromDate);
			  long diff = ToDate.getTime() - FromDate.getTime();
			  long hours = diff / (1000 * 60 * 60);
			  long minutes = diff / (1000 * 60) - hours * 60;
			  timeoffset = String.valueOf(hours)+":"+String.valueOf(minutes);
			  System.out.println(timeoffset);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeoffset;
		
	}
}
