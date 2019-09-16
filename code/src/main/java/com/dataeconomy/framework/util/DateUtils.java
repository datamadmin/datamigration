package com.dataeconomy.framework.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author Guvala
 *
 */
public class DateUtils {

	public static final String SIMPLE_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String DISPLAY_DATE_TIME_FORMAT = "dd-MMM-yyyy HH:mm:ss.SSS";
	public static final String DB_DATE_TIME_FORMAT ="yyyy-MM-dd HH:mm:ss.SSS";
	public static final String TIME_FORMAT = "hh:mm";
	public static final int EXPIRATION_DAYS = 90;

	public static String convertToFilterDateString(final LocalDate date) {
		if (date == null) {
			return null;
		}
		return date.format(DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT));
	}

	public static LocalDateTime convertLocalDateToLocalDateTime(final LocalDate date) {
		if (date == null) {
			return null;
		}
		return date.atTime(00, 00, 00);
	}

	public static String convertToDisplayFormat(final LocalDateTime date) {
		if (date == null) {
			return null;
		}
		return date.atZone(ZoneOffset.UTC).withZoneSameInstant(ZoneId.of(AppWebUtils.getCurrentTimeZone())).format(DateTimeFormatter.ofPattern(DateUtils.DISPLAY_DATE_TIME_FORMAT));
	}

	public static LocalDateTime getCurrentUTCDateTime() {
		return LocalDateTime.now(ZoneOffset.UTC);
	}

	public static LocalDateTime getPasswordExpirationDate() {
		return LocalDateTime.now(ZoneOffset.UTC).plusDays(EXPIRATION_DAYS);
	}

	public static LocalDate getCurrentUTCDate() {
		return LocalDate.now(ZoneOffset.UTC);
	}

	/**
	 * Parses the specified date string using the specified format and returns a
	 * Date object.
	 */
	public static LocalDate convertToLocalDate(final String dateString) {
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT));
	}
	
	public static LocalDateTime convertToLocalDateTime(final String dateString) {
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(DateUtils.DISPLAY_DATE_TIME_FORMAT)).atZone(ZoneId.of(AppWebUtils.getCurrentTimeZone()))
				.withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
	}

	public static LocalDate dateToLocalDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
	}

	public static LocalTime dateToLocalTimeHoursMinutes(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return LocalTime.of(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
	}

	public static LocalDate fromDate(Date date) {
		Instant instant = Instant.ofEpochMilli(date.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static String getCurrentLocaleDateTime() {
		return LocalDateTime.now(ZoneId.of(AppWebUtils.getCurrentTimeZone())).format(DateTimeFormatter.ofPattern(DISPLAY_DATE_TIME_FORMAT));
	}

	public static String getCurrentLocaleDateTime(String format) {
		return LocalDateTime.now(ZoneId.of(AppWebUtils.getCurrentTimeZone())).format(DateTimeFormatter.ofPattern(format));
	}

	public static Date getCurrentLocaleDate() {
		try {
			SimpleDateFormat sd = new SimpleDateFormat(DISPLAY_DATE_TIME_FORMAT);
			sd.setTimeZone(TimeZone.getTimeZone(AppWebUtils.getCurrentTimeZone()));
			return new SimpleDateFormat(DISPLAY_DATE_TIME_FORMAT).parse(sd.format(new Date()));
		} catch (ParseException e) {
			return null;
		}
	}

	public static LocalTime toLocalTime() {
		Instant instant = Instant.ofEpochMilli(new Date().getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.of(AppWebUtils.getCurrentTimeZone())).toLocalTime();
	}

	public static LocalTime convertToLocalTime(String value) {
		LocalTime localTime = null;
		if (value.contains(":")) {
			String[] timeArray = value.toString().split("\\:");
			localTime = LocalTime.of(Integer.valueOf(timeArray[0]), Integer.valueOf(timeArray[1]));
		} else {
			BigDecimal time = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("24"));
			String[] timeArray = time.toString().split("\\.");
			if (timeArray.length == 2) {
				localTime = LocalTime.of(Integer.valueOf(timeArray[0]), Integer.valueOf(timeArray[1]));
			}
		}
		return localTime;
	}

}
