package com.dataeconomy.framework.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author GASWANT
 *
 */
public class UIDateUtil {
	/**
	 * Method is used to find difference between two dates in no of months
	 * 
	 */
	public static int getDifferenceinMonths(Date nowDate, Date startDate) {
		int selPeriodMonths = 0;
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(nowDate);
		Calendar calStart = Calendar.getInstance();
		calStart.setTime(startDate);
		int periodType = calStart.compareTo(calNow);
		long diffTime = calNow.getTimeInMillis() - calStart.getTimeInMillis();
		Calendar calPeriod = Calendar.getInstance();
		calPeriod.setTimeInMillis(diffTime);
		selPeriodMonths = Math.abs((calPeriod.get(Calendar.YEAR) - 1970)) * 12;
		selPeriodMonths += calPeriod.get(Calendar.MONTH);
		return (periodType < 0) ? -selPeriodMonths : selPeriodMonths;
	}

	/**
	 * Converts date and time to a locale specific timestamp format
	 * 
	 * @param date
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static Timestamp parseDate(Date date, Date time, Locale locale) throws Exception {
		Timestamp t = null;
		if (date != null && time != null) {
			DateFormat dfDate = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			DateFormat dfTime = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
			String strDate = dfDate.format(date);
			String strTime = dfTime.format(time);
			Date d = df.parse(strDate + " " + strTime);
			t = new Timestamp(d.getTime());
		}
		return t;
	}

}
