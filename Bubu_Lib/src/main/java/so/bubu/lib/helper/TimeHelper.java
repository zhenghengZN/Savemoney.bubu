package so.bubu.lib.helper;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * TimeHelper:时间帮助类
 * 
 * @author linhuan 2015年7月15日上午9:18:06
 */
public class TimeHelper {
	
	public static final String YYYYMMDD = "yyyy年MM月dd日";
	public static final String MMDD = "MM月dd日";
	public static final String YYYYMMDDTWO = "yyyy-MM-dd";
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String HHMM = "HH:mm";
	public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

	/**
	 * getTimestamp:获取时间戳
	 * 
	 * @return
	 * 
	 * @author linhuan 2015年7月15日上午9:18:47
	 */
	public static long getTimestamp() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * date转GMT
	 *
	 * @param date
	 * @return
     */
	public static final String dateToGMT(Date date) {
		Locale aLocale = Locale.US;
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", new DateFormatSymbols(aLocale));
		fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
		return fmt.format(date);
	}
	
	/**
	 * timeToData:时间戳转时间字符串
	 * 
	 * @param timeFormat
	 * @return
	 * 
	 * @author linhuan 2015年7月16日上午11:46:21
	 */
	public static String timeToData(String timeFormat) {
		SimpleDateFormat format = new SimpleDateFormat(timeFormat);
		return format.format(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * timeToData:时间戳转时间字符串
	 * 
	 * @param time
	 * @param timeFormat
	 * @return
	 * 
	 * @author linhuan 2015年7月16日上午11:46:21
	 */
	public static String timeToData(long time, String timeFormat) {
		SimpleDateFormat format = new SimpleDateFormat(timeFormat);
		return format.format(new Date(time * 1000L));
	}
	
	/**
	 * timeToData:时间戳转时间字符串
	 * 
	 * @param time
	 * @param timeFormat
	 * @return
	 * 
	 * @author linhuan 2015年7月16日上午11:46:21
	 */
	public static int timeToInt(long time, String timeFormat) {
		SimpleDateFormat format =  new SimpleDateFormat(timeFormat);
		return Integer.valueOf(format.format(new Date(time)));
	}
	
	/**
	 * getTime:字符串转时间戳
	 * 
	 * @param timeFormat
	 * @return
	 * 
	 * @author linhuan 2015-11-26下午3:25:11
	 */
	public static String getTime(String userTime, String timeFormat) {  
		String re_time = "";  
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);  
			Date d = sdf.parse(userTime);
			long l = d.getTime();  
			String str = String.valueOf(l);  
			re_time = str.substring(0, 10);  
		} catch (ParseException e) {}  
		return re_time;  
	}

	/**
	 * getTime:字符串转时间戳
	 *
	 * @param timeFormat
	 * @return
	 *
	 * @author linhuan 2015-11-26下午3:25:11
	 */
	public static long getTimeLong(String userTime, String timeFormat) {
		long l = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
			Date d = sdf.parse(userTime);
			l = d.getTime() / 1000;
		} catch (ParseException e) {}
		return l;
	}

	/**
	 * 获取当天0点时间戳
	 *
	 * @return
     */
	public static int getTimesmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当天0点时间戳
	 *
	 * @return
	 */
	public static int getTimesThisYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

}
