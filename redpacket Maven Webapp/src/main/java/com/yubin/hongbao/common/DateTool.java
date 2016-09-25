package com.yubin.hongbao.common;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTool {
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_COMMON = "yyyyMMdd";
    private static final String DATE_COMMON2 = "yyyyMM";
	public static final String End_FORMAT = "yyyyMMddHHmmss";
	public static final String TIME_COMMON = "HHmmss";
	public static final String TIME_COMMON2 = "HH:mm:ss";
    private static SimpleDateFormat dateFormatTemp ;
    
    
    
    /**
     * 
     * @description：将一个日期加对应年/月/日（可设置日期格式）
     * @param format 日期StrDate的格式，比如yyyyMMdd,或yyyy-MM-dd
     * @param StrDate 日期
     * @param year 年
     * @param month	月
     * @param day	日
     * @return
     */
    public static String CalDate(String format,String StrDate,int year, int month, int day)  {   
		Calendar   cal   =   Calendar.getInstance();   
		SimpleDateFormat   sFmt   =   new   SimpleDateFormat(format);   
		cal.setTime(sFmt.parse(   (StrDate),   new   ParsePosition(0)));   
		 
		if(year != 0) {   
			cal.add(cal.YEAR,   year);   
		}  
		if(month != 0){   
			cal.add(cal.MONTH,   month);   
		}  
		if(day != 0){   
			cal.add(cal.DATE,   day);   
		}
		return sFmt.format(cal.getTime());   
	}   
    
	/**
	 * 字符串类型时间转换成Date类型时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date toDateTime(String str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		SimpleDateFormat dateFormatTemp = new SimpleDateFormat(DATETIME_FORMAT);
		try {
			return dateFormatTemp.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符串类型时间转换成Date类型时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date toDate(String str) {
		if (CommonUtil.isEmpty(str)) {
			return null;
		}
		
		try {
			return new SimpleDateFormat(DATE_FORMAT).parse(str);
		} catch (ParseException e) {
			//e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串类型时间转换成Date类型时间
	 * 
	 * @param date 日期
	 * @param format 格式：比如 yyyy-mm-dd
	 * @return null格式错误
	 */
	public static Date formatDate(String date,String format) {
		Date date2 = null;
		
		if(CommonUtil.isEmpty(date)) {
			return null;
		}
		
		try {
			date2 = new SimpleDateFormat(format).parse(date); 
		} catch (ParseException e) {
			return null;
		}
		return date2;
	}

	/**
	 * 时间比较，看end是否大于begin�? 如果时间为空则返回false�? 如果时间格式不正确则返回false
	 * 
	 * @param begin
	 *            �?始时�?
	 * @param end
	 *            结束时间
	 * @return
	 */
	public static boolean dateTimeAfter(String begin, String end) {
		if (CommonUtil.isEmpty(begin) || CommonUtil.isEmpty(end)) {
			return false;
		}
		SimpleDateFormat dateFormatTemp = new SimpleDateFormat(DATETIME_FORMAT);
		try {
			return dateFormatTemp.parse(end).after(dateFormatTemp.parse(begin));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 时间比较，看end是否大于begin�? 如果时间为空则返回false�? 如果时间格式不正确则返回false
	 * 
	 * @param begin
	 *            �?始时�?
	 * @param end
	 *            结束时间
	 * @return
	 */
	public static boolean dateAfter(String begin, String end) {
		if (CommonUtil.isEmpty(begin) || CommonUtil.isEmpty(end)) {
			return false;
		}
		SimpleDateFormat dateFormatTemp = new SimpleDateFormat(DATE_FORMAT);
		try {
			return dateFormatTemp.parse(end).after(dateFormatTemp.parse(begin));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 时间比较，看end是否大于当前时间�? 如果时间为空则返回false�? 如果时间格式不正确则返回false
	 * 
	 * @param end
	 *            结束时间
	 * @return
	 */
	public static boolean dateAfter(String end) {
		if (CommonUtil.isEmpty(end)) {
			return false;
		}
		SimpleDateFormat dateFormatTemp = new SimpleDateFormat(DATE_FORMAT);
		try {
			return dateFormatTemp.parse(end).after(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @see 取得当前日期（格式为：yyyy-MM-dd�?
	 * @return String
	 */
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String sDate = sdf.format(new Date());
		return sDate;
	}
	
	
	/**
	 * @see 取得当前日期（格式为：yyyyMMdd
	 * @return String
	 */
	public static String getTinyDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_COMMON);
		String sDate = sdf.format(new Date());
		return sDate;
	}
	
	/**
	 * @see 取得当前时间（格式为：hhmmss
	 * @return String
	 */
	public static String getTinyTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_COMMON);
		String sTime = sdf.format(new Date());
		return sTime;
	}
	
	/**
	 * @see 取得当前时间（格式为：HH:mm:ss
	 * @return String
	 */
	public static String getCommonTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_COMMON2);
		String sTime = sdf.format(new Date());
		return sTime;
	}
	
	
	/**
	 * @see 取得当前日期（格式为：yyyyMM)
	 * @return String
	 */
	public static String getYearMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_COMMON2);
		String sDate = sdf.format(new Date());
		return sDate;
	}
	
	/**
	 * 
	 * @description：
	 * @param startDate 开始日期  格式"yyyyMMDD"
	 * @param endDate	结束日期
	 * @return  
	 */
	public static long getDifDate(String startDate, String endDate) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		
		Long c = null;
		try {
			c = sf.parse(endDate).getTime()-sf.parse(startDate).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		long d = c/1000/60/60/24;//天
		
		return d;
	}
	
	
	/**
	 * @see 得到两日期相差几个月 （日期格式yyyyMMdd）
	 * @return String
	 */
	public static long getMonth(String startDate, String endDate) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        long monthday;
        try {
            Date startDate1 = f.parse(startDate);
            //开始时间与今天相比较
            Date endDate1 = new Date();

            Calendar starCal = Calendar.getInstance();
            starCal.setTime(startDate1);

            int sYear = starCal.get(Calendar.YEAR);
            int sMonth = starCal.get(Calendar.MONTH);
            int sDay = starCal.get(Calendar.DATE);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate1);
            int eYear = endCal.get(Calendar.YEAR);
            int eMonth = endCal.get(Calendar.MONTH);
            int eDay = endCal.get(Calendar.DATE);

            monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

            if (sDay < eDay) {
                monthday = monthday + 1;
            }
            return monthday;
        } catch (ParseException e) {
        	e.printStackTrace();
            monthday = 0;
        }
        return monthday;
	}
	
	
	/**
	 * @see 得到两个月份相差几个月 （日期格式yyyyMM）
	 * @return String
	 */
	public static long getSpanMonth(String startDate, String endDate) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMM");
        long monthday;
        try {
            Date startDate1 = f.parse(startDate);
            //开始时间与今天相比较
            Date endDate1 = f.parse(endDate);

            Calendar starCal = Calendar.getInstance();
            starCal.setTime(startDate1);

            int sYear = starCal.get(Calendar.YEAR);
            int sMonth = starCal.get(Calendar.MONTH);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate1);
            int eYear = endCal.get(Calendar.YEAR);
            int eMonth = endCal.get(Calendar.MONTH);

            monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));	
            return monthday;
        } catch (ParseException e) {
        	e.printStackTrace();
            monthday = 0;
        }
        return monthday;
	}

	/**
	 * @see 取得当前时间（格式为：yyyy-MM-dd HH:mm:ss?
	 * @return String
	 */
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		String sDate = sdf.format(new Date());
		return sDate;
	}

	/**
	 * @see 取得当前时间（格式为：yyyMMddHHmmss?
	 * @return String
	 */
	public static String getEndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(End_FORMAT);
		String sDate = sdf.format(new Date());
		return sDate;
	}
	/**
	 * @see 取得当前时间（格式为：yyyMMddHHmmss?
	 * @return String
	 */
	public static String getEndTime(int adjustSecond) {
		SimpleDateFormat sdf = new SimpleDateFormat(End_FORMAT);
		String sDate = sdf.format(new Date(new Date().getTime()-adjustSecond*1000));
		return sDate;
	}

	/**
	 * @see 将时间转化为字符�? (格式:yyy-MM-dd HH:mm:ss)
	 * @return String
	 */
	public static String toDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		return (null != date) ? sdf.format(date) : " ";
	}

	/**
	 * 取得字符串日期（格式为：yyyy-MM-dd�?
	 * 
	 * @param calendar
	 * @return
	 */
	public static String toDateStr(GregorianCalendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 取得字符串日期（格式为：yyyy-MM-dd HH:mm:ss�?
	 * 
	 * @param calendar
	 * @return
	 */
	public static String toDateTimeStr(GregorianCalendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 将形如：yyyy-MM-dd HH:mm:ss的日期转换成GregorianCalendar类型
	 * 
	 * @param calendarStr
	 * @return
	 */
	public static GregorianCalendar toDateTimeCalendar(String calendarStr) {
		if (calendarStr == null) {
			return null;
		}
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
			Date date = dateFormat.parse(calendarStr);
			GregorianCalendar rv = new GregorianCalendar();
			rv.setTime(date);
			return rv;
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将形如：yyyy-MM-dd的日期转换成GregorianCalendar类型
	 * 
	 * @param calendarStr
	 * @return
	 */
	public static GregorianCalendar toDateCalendar(String calendarStr) {
		if (calendarStr == null) {
			return null;
		}
		try {
			SimpleDateFormat dateDayFormat = new SimpleDateFormat(DATE_FORMAT);
			Date date = dateDayFormat.parse(calendarStr);
			GregorianCalendar rv = new GregorianCalendar();
			rv.setTime(date);
			return rv;
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @method addDay: 根据天数和小时数以及分钟确定时间
	 * @param dateField
	 * @param days
	 * @param hour
	 * @return xxxxxxx
	 * @return GregorianCalendar xxxxxxxx
	 * @throws
	 */
	public static GregorianCalendar addTime(GregorianCalendar dateField,
			int days, int hours, int minute) {
		long dateTime = dateField.getTimeInMillis();
		if (days < 0)
			return dateField;
		long daysTime = days * 24 * 60 * 60 * 1000L;
		long hoursTime = hours * 60 * 60 * 1000L;
		long minuteTime = minute * 60 * 1000L;
		long newDateTime = dateTime + daysTime + hoursTime + minuteTime;
		GregorianCalendar newDate = new GregorianCalendar();
		newDate.setTimeInMillis(newDateTime);
		return newDate;
	}

	/**
	 * 小时的加�?
	 * 
	 * @param dateField
	 *            GregorianCalendar 基础时间
	 * @param days
	 *            int 要加的时�?
	 * @return GregorianCalendar
	 */
	public static GregorianCalendar addDay(GregorianCalendar dateField, int days) {
		dateField.add(GregorianCalendar.DATE, days);
		return dateField;
	}

	/**
	 * 
	 * @method now: 返回当前时间
	 * @Date 2009/Sep 14, 2009
	 * @return
	 */
	public static GregorianCalendar getNow() {
		return new GregorianCalendar();
	}

	/**
	 * @fucntion 取得n天后的日期（格式为yyyy-MM-dd HH:mm:ss�?
	 * @param days
	 * @return
	 */
	public static String dateAfter(int days) {
		return toDateTimeStr(addDay(getNow(), days));
	}


	private static ThreadLocal threadlocal = new ThreadLocal() {
		protected synchronized Object initialValue() {
			return new SimpleDateFormat(DATE_COMMON);
		}
	};

	public static SimpleDateFormat getDateFormat() {
		
		return (SimpleDateFormat) threadlocal.get();
	}

	public static Date parse(String textdate) throws ParseException {
		return getDateFormat().parse(textdate);
	}
	

	/**
	 * 获得指定日期的前几天
	 * 
	 * @param strDate yyyyMMdd
	 * @return
	 * @throws Exception
	 */
	public static String getDateBefore(String strDate,int num) {
	
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(DATE_COMMON).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - num);

		String dayBefore = new SimpleDateFormat(DATE_COMMON).format(c
				.getTime());
		return dayBefore;
	}
	/**
	 * 获得特定格式指定日期的前几天
	 * 
	 * @param strDate 
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String getDateBefore(String strDate,String format,int num) {
	
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - num);

		String dayBefore = new SimpleDateFormat(format).format(c
				.getTime());
		return dayBefore;
	}

	/**
	 * 获得指定日期的后几天
	 * 
	 * @param strDate yyyyMMdd
	 * @return
	 */
	public static String getDateAfter(String strDate,int num) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(DATE_COMMON).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);

		String dayAfter = new SimpleDateFormat(DATE_COMMON)
				.format(c.getTime());
		return dayAfter;
	}
	
	/**
	 * 获得指定日期的后几天
	 * 
	 * @param strDate yyyyMMdd
	 * @return
	 */
	public static String getDateAfter(String strDate,String format,int num) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);

		String dayAfter = new SimpleDateFormat(format)
				.format(c.getTime());
		return dayAfter;
	}
	
	public static void main(String[] args) {
		Date  date =  DateTool.formatDate("20160124", "yyyyMMdd");
		Date  date2 =  DateTool.formatDate("20160123", "yyyyMMdd");

		System.out.println(getEndTime(60));
		System.out.println(getDifDate("20160412","20160412"));

		System.out.println(CalDate("yyyyMMdd","20160422", 0, 14, 0));

		System.out.println(getDateBefore("2016-04-18",DATE_FORMAT,1));
	}

}