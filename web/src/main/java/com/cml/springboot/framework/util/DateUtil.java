package com.cml.springboot.framework.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

	protected static final Log LOG = LogFactory.getLog(DateUtil.class);

	public static final int RESULT_FROM_DATE_ERROR = 1;

	public static final int RESULT_TO_DATE_ERROR = 2;

	public static final int RESULT_FROM_DATE_AFTER_TO_DATE = 3;

	public static final int RESULT_SUCCESS = 0;

	/** フォーマット : YYYY/MM/DD HH:MI */
	private static final SimpleDateFormat DF_YMDHMS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/** Validate Methods */

	public static boolean validateTimeFormat(String year, String month, String day, String hour, String minute) {

		if (StringUtils.isBlank(year) && StringUtils.isBlank(month) && StringUtils.isBlank(day)
				&& StringUtils.isBlank(hour) && StringUtils.isBlank(minute)) {
			return true;
		}

		Date dt = getDate(year, month, day, hour, minute);
		if (dt == null) {
			return false;
		}

		return formatDateTime(dt, DateFormatter.SDF_YMDHM).equals(year + month + day + hour + minute);

	}

	public static boolean validateDateFormat(String year, String month, String day) {

		if (StringUtils.isBlank(year) && StringUtils.isBlank(month) && StringUtils.isBlank(day)) {
			return true;
		}

		Date dt = getDate(year, month, day, "00", "00");

		if (dt == null) {
			return false;
		}

		return formatDateTime(dt, DateFormatter.SDF_YMDHM).equals(year + month + day + "00" + "00");
	}

	/**
	 * Calculating the number of months between two dates eg：2011-02-02 and
	 * 2011/02/01
	 * 
	 * @param startDate
	 * @param endDate
	 * @return int
	 */
	public static int getMonthsBetween(String startDate, String endDate) {
		String lastYear = startDate.substring(0, 4);
		String lastMonth = startDate.substring(5, 7);
		String registYear = endDate.substring(0, 4);
		String registMonth = endDate.substring(5, 7);
		int year2 = Integer.parseInt(lastYear);
		int year1 = Integer.parseInt(registYear);
		int month2 = Integer.parseInt(lastMonth);
		int month1 = Integer.parseInt(registMonth);
		int months;
		if (month2 < month1) {
			months = month2 + 10 - month1 + (year2 - year1) * 12;
		} else {
			months = month2 - month1 + (year2 - year1) * 12;
		}
		return months;

	}

	/**
	 * 日付文字チェック
	 * 
	 * @param String
	 *            str
	 * @param String
	 *            format YYYY/MM/DD
	 * @return
	 */
	public static boolean validateDateFormat(String str, String format) {

		if (null == str || null == format)
			return false;

		Pattern pattern = Pattern.compile("(Y{4}).*(M{2}).*(D{2})");
		Matcher matcher = pattern.matcher(format);
		if (!matcher.lookingAt()) {
			return false;
		}

		format = format.replaceFirst(matcher.group(1), "(\\\\d{4})");
		format = format.replaceFirst(matcher.group(2), "(\\\\d{2})");
		format = format.replaceFirst(matcher.group(3), "(\\\\d{2})");
		pattern = Pattern.compile(format);

		matcher = pattern.matcher(str);
		if (matcher.lookingAt()) {
			if (DateUtil.validateDateFormat(matcher.group(1), matcher.group(2), matcher.group(3))) {
				return true;
			}
		}
		return false;
	}

	public static Date getDate(String year, String month, String day, String hour, String minute) {
		try {
			DateTime dt = new DateTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
					Integer.parseInt(hour), Integer.parseInt(minute), 0, 0);
			return dt.toDate();
		} catch (NumberFormatException e) {
			return null;
		}

	}

	public static java.sql.Date parseSqlDate(String date) {

		if (!StringUtils.isBlank(date)) {
			Date d = DateUtil.parseDateTime(date, DateFormatter.SDF_YMD);
			if (d == null) {
				return null;
			}
			java.sql.Date d2 = new java.sql.Date(d.getTime());
			return d2;
		}
		return null;

	}

	public static Timestamp getTimestamp(String year, String month, String day, String hour, String minute) {
		try {
			return new Timestamp(getDate(year, month, day, hour, minute).getTime());
		} catch (Exception e) {
			return null;
		}
	}

	public static int validateFromToDate(String fromYear, String fromMonth, String fromDay, String toYear,
			String toMonth, String toDay) {
		if (!validateDateFormat(fromYear, fromMonth, fromDay))
			return RESULT_FROM_DATE_ERROR;
		if (!validateDateFormat(toYear, toMonth, toDay))
			return RESULT_TO_DATE_ERROR;

		if (!StringUtils.isBlank(fromYear) && !StringUtils.isBlank(toYear)) {
			if (getDate(fromYear, fromMonth, fromDay, "00", "00").after(getDate(toYear, toMonth, toDay, "00", "00")))
				return RESULT_FROM_DATE_AFTER_TO_DATE;
		}

		return RESULT_SUCCESS;
	}

	public static int validateFromToTime(String fromYear, String fromMonth, String fromDay, String fromHour,
			String fromMinute, String toYear, String toMonth, String toDay, String toHour, String toMinute) {
		if (!validateTimeFormat(fromYear, fromMonth, fromDay, fromHour, fromMinute))
			return RESULT_FROM_DATE_ERROR;
		if (!validateTimeFormat(toYear, toMonth, toDay, toHour, toMinute))
			return RESULT_TO_DATE_ERROR;
		if (!StringUtils.isBlank(fromYear) && !StringUtils.isBlank(toYear)) {
			if (getDate(fromYear, fromMonth, fromDay, fromHour, fromMinute)
					.after(getDate(toYear, toMonth, toDay, toHour, toMinute)))
				return RESULT_FROM_DATE_AFTER_TO_DATE;
		}

		return RESULT_SUCCESS;
	}

	public static String getSelTime(String year, String month, String day, String hour, String minute) {

		StringBuffer sb = new StringBuffer();
		if (!StringUtils.isBlank(year))
			sb.append(year);
		else
			sb.append("9999");
		if (!StringUtils.isBlank(month))
			sb.append(month);
		else
			sb.append("99");
		if (!StringUtils.isBlank(day))
			sb.append(day);
		else
			sb.append("99");
		if (!StringUtils.isBlank(hour))
			sb.append(hour);
		else
			sb.append("99");
		if (!StringUtils.isBlank(minute))
			sb.append(minute);
		else
			sb.append("99");
		return sb.toString();
	}

	public static String getSelDate(String year, String month, String day) {

		StringBuffer sb = new StringBuffer();

		if (!StringUtils.isBlank(year))
			sb.append(year);
		else
			sb.append("9999");
		if (!StringUtils.isBlank(month))
			sb.append(month);
		else
			sb.append("99");
		if (!StringUtils.isBlank(day))
			sb.append(day);
		else
			sb.append("99");
		return sb.toString();
	}

	public static String getPassTime(long timeGap) {
		if (timeGap < 0)
			return "00:00:00";

		DecimalFormat df = new DecimalFormat("00");
		long hour = timeGap / 60 / 60;

		long minute = timeGap / 60 - hour * 60;

		long second = timeGap - hour * 60 * 60 - minute * 60;

		StringBuffer sb = new StringBuffer();
		sb.append(df.format(hour));
		sb.append(":");
		sb.append(df.format(minute));
		sb.append(":");
		sb.append(df.format(second));

		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * 日時チェックおよびyyyy.m.d＝＞YYYY.MM.DD
	 * 
	 * @param str
	 * @return String str
	 */
	public static String isChangeDate(String str) {

		Pattern pattern = Pattern.compile("[0-9]{4}\\.[0-9]{1,2}\\.[0-9]{1,2}");
		Matcher matcher = pattern.matcher(str);
		matcher = pattern.matcher(str);

		if (matcher.lookingAt()) {
			String[] strList = str.split("\\.");
			str = strList[0];
			if (strList[1].length() == 1)
				str = str + ".0" + strList[1];
			else
				str = str + "." + strList[1];
			if (strList[2].length() == 1)
				str = str + ".0" + strList[2];
			else
				str = str + "." + strList[2];
		}

		return str;
	}

	public static boolean judgeTime(String str) {
		try {
			String[] array = StringUtils.split(":");
			int hour = Integer.parseInt(array[0]);
			int minute = Integer.parseInt(array[1]);
			int second = Integer.parseInt(array[2]);
			if (hour > 24 || hour < 0 || minute >= 60 || minute < 0 || second >= 60 || second < 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// /////////////////////////////////////////

	public static Date parseDateTime(String date, String format) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);
			return df.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String formatDateTime(Date dt, String format) {
		DateTime dateTime = new DateTime(dt);
		return dateTime.toString(format);
	}

	public static String formatDateTime(DateTime dt, String format) {
		return dt == null ? null : dt.toString(format);
	}

	/**
	 * return a String of Date,eg:20100628
	 * 
	 * @param format
	 *            eg:YYYYMMdd
	 * @return str
	 * @throws Exception
	 */
	public static String getNowWithFormat(String format) {
		DateTime dateTime = new DateTime();
		return dateTime.toString(format);
	}

	/**
	 * get a String of current date's million seconds from 1970/01/01
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDateMilliseconds() throws Exception {
		return String.valueOf(DateTime.now().getMillis());
	}

	/**
	 * get Japanese Day Of Week
	 * 
	 * 
	 * @param dt
	 *            -> 2010.6.8
	 * @return String -> "火"
	 * @throws Exception
	 */
	public static String getJapaneseDayOfWeek(DateTime dt) throws Exception {

		if (null != dt) {
			DateTime.Property pDow = dt.dayOfWeek();
			return pDow.getAsShortText(Locale.JAPAN);
		}
		return "";
	}

	public static DateTime parseDate(String date, String format) {
		try {
			DateTimeFormatter formatter = DateTimeFormat.forPattern(format).withZoneUTC();
			DateTime dateTime = formatter.parseDateTime(date);
			return dateTime;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DateTime parseDateNoWithZoneUTC(String date, String format) {
		try {
			DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
			DateTime dateTime = formatter.parseDateTime(date);
			return dateTime;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static DateTime parseDate(String date, String hh, String mm, String format) {
		try {

			if (!StringUtils.isNumeric(hh) || !StringUtils.isNumeric(mm)) {
				return null;
			}

			hh = StringUtils.leftPad(hh, 2, '0');
			mm = StringUtils.leftPad(mm, 2, '0');

			date = date + " " + hh + ":" + mm;

			DateTimeFormatter formatter = DateTimeFormat.forPattern(format).withZoneUTC();
			DateTime dateTime = formatter.parseDateTime(date);
			return dateTime;
		} catch (Exception e) {
			return null;
		}
	}

	public static DateTime parseDateTimeFormat(String date, String hh, String mm, String ss, String format) {
		try {

			if (!StringUtils.isNumeric(hh) || !StringUtils.isNumeric(mm) || !StringUtils.isNumeric(ss)) {
				return null;
			}

			date = date.replaceAll("/", "-");

			hh = StringUtils.leftPad(hh, 2, '0');
			mm = StringUtils.leftPad(mm, 2, '0');
			ss = StringUtils.leftPad(ss, 2, '0');

			date = date + " " + hh + ":" + mm + ":" + ss;

			DateTimeFormatter formatter = DateTimeFormat.forPattern(format).withZoneUTC();
			DateTime dateTime = formatter.parseDateTime(date);
			return dateTime;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Return the first day of datetime
	 * 
	 * @param date
	 * @return DateTime
	 */
	public static DateTime getFirstDayOfTheMonth(DateTime date) {
		if (null == date) {
			return null;
		}

		date = new DateTime(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), 0, 0, 0, 0);

		return date.dayOfMonth().withMinimumValue();
	}

	/**
	 * Return the last day of datetime
	 * 
	 * @param date
	 * @return DateTime
	 */
	public static DateTime getLastDayOfTheMonth(DateTime date) {
		if (null == date) {
			return null;
		}

		date = new DateTime(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), 23, 59, 59, 999);

		return date.dayOfMonth().withMaximumValue();
	}

	public static String formatYMDHMS(Date date) {
		return ((SimpleDateFormat) DF_YMDHMS.clone()).format(date);
	}

	/**
	 * 期間日時日分時間の変換
	 * 
	 * @param date
	 *            :期間
	 * @param hour
	 *            :日時
	 * @param minute
	 *            :日分
	 * @return
	 */
	public static DateTime dateTransform(String date, String hour, String minute) {

		// 期間日
		DateTime dayTime = null;

		// 期間日フォーマット
		if (StringUtils.isNotBlank(date)) {
			dayTime = DateUtil.parseDate(date, DateFormatter.SDF_YMD9);
			if (StringUtils.isNotBlank(hour) && StringUtils.isNotBlank(minute)) {
				return dayTime.plusHours(Integer.valueOf(hour)).plusMinutes(Integer.valueOf(minute));
			}
		}

		return dayTime;

	}

	/**
	 * {@link LocalTime}は{@link java.sql.Time}を変換する
	 * 
	 * @param time
	 *            a time
	 * @return {@link java.sql.Time}
	 */
	public static java.sql.Time convert(LocalTime time) {
		return new java.sql.Time(time.toDateTimeToday().getMillis());
	}

	/**
	 * 判断dateFrom日期字符串 dateFrom 是否小于 dateTo :小于返回true，大于等于返回false
	 * 
	 * @param dateFrom
	 *            开始日期 格式
	 * @param dateTo
	 *            结束日期 格式
	 * @param dateFormat
	 *            日期格式(如:yyyy/MM/dd)
	 * @return 如果 dateFrom 小于 dateTo ，返回true，大于等于返回false
	 */
	public static boolean isFirstSmallDate(String dateFrom, String dateTo, String dateFormat) {
		if (dateFrom != null && dateFrom.equalsIgnoreCase(dateTo)) {
			return false;
		}

		DateTime from = DateUtil.parseDate(dateFrom, dateFormat);
		DateTime to = DateUtil.parseDate(dateTo, dateFormat);
		return from.isBefore(to);
	}

}
