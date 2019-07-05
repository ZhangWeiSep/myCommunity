package indi.zhangwei.community.utils.TimeUtils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期
 *
 * @author zWX162550
 * @version ONIP BME V300R001 2013-3-7
 * @since ONIP BME V300R001C00
 */
public final class DateUtils {
    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 精确到毫秒第3位
     */
    public static String FORMAT_FULLS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 中文简写 如：2010年12月01日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    /**
     * 流水号格式
     */
    public static String FORMAT_TRANSID = "yyyyMMddHHmmssSSS";

    /**
     * 处理时间格式
     */
    public static String FORMAT_PROCESSTIME = "yyyyMMddHHmmss";

    /**
     * 处理时间格式(生成编号)
     */
    public static String FORMAT_YYYY_MM_DD_HH_MM = "yyyyMMddHHmm";

    /**
     * Kafka时间格式
     */
    public static String FORMAT_LONGTIME = "yyyyMMddHHmmssSSS";

    /**
     * 处理时间格式 yyyyMM
     */
    public static String FORMAT_YEAR_MONTH = "yyyyMM";

    /**
     * 时间格式 yyyyMMdd
     */
    public static String FORMAT_YEAR_MONTH_DAY = "yyyyMMdd";

    /**
     * 时间格式 yyyyMMdd
     */
    public static String FORMAT_HH_MM_SS = "HHmmss";

    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern() {
        return FORMAT_LONG;
    }

    /**
     * 根据预设格式返回当前日期
     *
     * @return
     */
    public static String getNow() {
        return format(new Date());
    }

    /**
     * 根据用户格式返回当前日期
     *
     * @param format
     * @return
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加小时
     *
     * @param date 日期
     * @param n    要增加的小时
     * @return
     */
    public static Date addHours(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, n);
        return cal.getTime();
    }

    /**
     * 获取时间戳
     */
    public static String getTimeString() {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 获取日期年份
     *
     * @param date 日期
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return
     */
    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 根据给定不同的类型 返回不同的日期格式。
     *
     * @param date
     * @param type
     * @return
     */
    public static String dateToStr(Date date, int type) {
        if (type == 0) {
            SimpleDateFormat dateShort = new SimpleDateFormat("yyyy-MM-dd");
            return dateShort.format(date);
        } else if (type == 1) {
            SimpleDateFormat dateLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
            return dateLong.format(date);
        } else {
            return "";
        }

    }

    /**
     * @param date
     * @return
     */
    public synchronized static String getTransId() {
        String transId = DateUtils.getNow(FORMAT_TRANSID);

        // 加上三位随机数,防止并发
        return transId + (int) (Math.random() * 900 + 100);
    }

    /**
     * 房源交易编号
     *
     * @return
     */
    public synchronized static String getHouseOrderID() {
        String traceUniqueID = DateUtils.getNow(FORMAT_TRANSID) + (int) (Math.random() * 900 + 100);

        return traceUniqueID;
    }

    /**
     * @return
     */
    public static String getProcessTime() {
        String processTime = DateUtils.getNow(FORMAT_PROCESSTIME);
        return processTime;
    }

    public static Date getRequestTime() {
        String requestTime = DateUtils.getNow(FORMAT_PROCESSTIME);
        Date date = DateUtils.parse(requestTime, FORMAT_PROCESSTIME);
        return date;
    }

    /**
     * 通过解析方法
     *
     * @param sDate
     * @return
     */
    public static Date commonParse(String sDate) {
        Date date = null;
        if (StringUtils.isEmpty(sDate)) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_FULL);
        if (date != null) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_LONG);
        if (date != null) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_SHORT);
        if (date != null) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_FULL_CN);
        if (date != null) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_LONG_CN);
        if (date != null) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_SHORT_CN);
        if (date != null) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_TRANSID);
        if (date != null) {
            return date;
        }

        /**
         * 尝试
         */
        date = parseDate(sDate, FORMAT_PROCESSTIME);
        if (date != null) {
            return date;
        }

        return date;
    }

    private static Date parseDate(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 比较两个时间的大小 返回大的那个。
     *
     * @param d1
     * @param d2
     * @return Date
     */
    public static Date getNewTime(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            return d1.getTime() > d2.getTime() ? d1 : d2;
        } else {
            return null;
        }
    }

    /**
     * 获取UTC time。
     *
     * @param d1
     * @param d2
     * @return Date
     */
    public static String covert2UTCTime(Date date, String format) {
        if ((null == format) || (format.trim().length() == 0)) {
            format = FORMAT_PROCESSTIME;
        }

        DateFormat formatter = new SimpleDateFormat(format);
        TimeZone utcTimezone = TimeZone.getTimeZone("GMT-0");
        formatter.setTimeZone(utcTimezone);
        String utc_date = formatter.format(date);
        return utc_date;
    }
}
