package com.byteearth.eatwatermelon.util;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @author W_wang
 * @version V1.0
 * @remark 日期工具
 * @email 1352255400@qq.com
 * @date 2020/8/4 17:22
 */
@Slf4j
public class DateUtils {

    private DateUtils() {
    }

    public final static String DATE = "yyyy-MM-dd";
    public final static String DATE_SLASH = "yyyy/MM/dd";
    public final static String DATE_CHINESE = "yyyy年MM月dd日";

    public final static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_TIME_HOURS = "yyyy-MM-dd HH";
    public final static String DATE_TIME_MINUTES = "yyyy-MM-dd HH:mm";
    public final static String DATE_TIME_SLASH = "yyyy/MM/dd HH:mm:ss";
    public final static String DATE_TIME_CHINESE = "yyyy年MM月dd日 HH时mm分ss秒";

    public final static String DATE_TIME_MILLION = "yyyy-MM-dd HH:mm:ss:SSS";

    public final static String YEAR = "yyyy";
    public final static String YEAR_TO_MONTH = "yyyyMM";
    public final static String YEAR_TO_DATE = "yyyyMMdd";
    public final static String YEAR_TO_SECOND = "yyyyMMddHHmmss";
    public final static String YEAR_TO_MILLION = "yyyyMMddHHmmssSSS";

    public final static String ZERO_TIME = " 00:00:00";
    public final static String ZERO_TIME_MILLION = " 00:00:00:000";
    public final static String ZERO_TIME_WITHOUT_HOURS = ":00:00";
    public final static String ZERO_TIME_WITHOUT_MINUTES = ":00";

    public final static String END_TIME = " 23:59:59";


    /**
     * 字符串转成日期、时间格式
     *
     * @param dateString 日期字符串
     * @param pattern    格式化类型，默认为yyyy-MM-dd，其它使用DateUtils.xxx
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateString, String pattern) throws ParseException {
        if (StringUtils.isBlank(dateString)) {
            return null;
        } else {
            dateString = dateString.trim();
            if (StringUtils.isBlank(pattern)) {
                pattern = DATE;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.parse(dateString);
        }
    }

    /**
     * 字符串转成日期（yyyy-MM-dd）格式
     *
     * @param dateString 日期字符串
     * @return Date
     * @throws ParseException
     */
    public static Date parseDate(String dateString) throws ParseException {
        return parse(dateString, null);
    }

    /**
     * 字符串转成时间（yyyy-MM-dd HH:mm:ss）格式
     *
     * @param dateString 日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parseDateTime(String dateString) throws ParseException {
        if (StringUtils.isBlank(dateString)) {
            return null;
        } else {
            dateString = dateString.trim();
            if (dateString.length() == DATE_TIME_HOURS.length()) {
                return parse(dateString, DATE_TIME_HOURS);
            } else if (dateString.length() == DATE_TIME_MINUTES.length()) {
                return parse(dateString, DATE_TIME_MINUTES);
            } else if (dateString.length() == DATE_TIME_MILLION.length()) {
                return parse(dateString, DATE_TIME_MILLION);
            } else {
                return parse(dateString, DATE_TIME);
            }
        }
    }

    /**
     * 时间转字符串
     *
     * @param date    时间
     * @param pattern 格式化类型，默认为yyyy-MM-dd HH:mm:ss，其它使用DateUtils.xxx
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        } else {
            if (StringUtils.isBlank(pattern)) {
                pattern = DATE_TIME;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        }
    }

    /**
     * 时间转日期字符串（yyyy-MM-dd）
     *
     * @param date 时间
     * @return
     */
    public static String formatDate(Date date) {
        return format(date, DATE);
    }

    /**
     * 时间转日期字符串（yyyy-MM-dd HH:mm:ss）
     *
     * @param date 时间
     * @return
     */
    public static String formatDateTime(Date date) {
        return format(date, null);
    }

    /**
     * 将日期格式转换成时间（yyyy-MM-dd HH:mm:ss）格式
     *
     * @param dateString 日期字符串
     * @return
     */
    public static String dateToDateTime(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return "";
        } else {
            dateString = dateString.trim();
            if (dateString.length() == DATE.length()) {
                return dateString + ZERO_TIME;
            } else if (dateString.length() == DATE_TIME_HOURS.length()) {
                return dateString + ZERO_TIME_WITHOUT_HOURS;
            } else if (dateString.length() == DATE_TIME_MINUTES.length()) {
                return dateString + ZERO_TIME_WITHOUT_MINUTES;
            } else if (dateString.length() == DATE_TIME_MILLION.length()) {
                return dateString.substring(0, DATE_TIME.length());
            } else {
                return dateString;
            }
        }
    }

    public static String dateToDateTimeStart(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return "";
        } else {
            dateString = dateString.trim();
            if (dateString.length() == DATE.length()) {
                return dateString + ZERO_TIME;
            }
        }
        return dateString;
    }

    public static String dateToDateTimeEnd(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return "";
        } else {
            dateString = dateString.trim();
            if (dateString.length() == DATE.length()) {
                return dateString + END_TIME;
            }
        }
        return dateString;
    }

    /**
     * 将日期格式转换成时间（时分秒毫秒）格式
     *
     * @param dateString 日期字符串
     * @return
     */
    public static String dateToDateTimeMillion(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return "";
        } else {
            dateString = dateString.trim();
            return dateString + ZERO_TIME_MILLION;
        }
    }


    /**
     * 将时间字（yyyy-MM-dd HH:mm:ss）符串转换成日期（yyyy-MM-dd）格式
     *
     * @param dateTimeString 时间字符串
     * @return String
     */
    public static String dateTimeToDate(String dateTimeString) {
        if (StringUtils.isBlank(dateTimeString)) {
            return "";
        } else {
            dateTimeString = dateTimeString.trim();
            if (dateTimeString.length() >= DATE.length()) {
                return dateTimeString.substring(0, DATE.length());
            } else {
                return dateTimeString;
            }
        }
    }


    /**
     * 将时间字（yyyy-MM-dd HH:mm:ss）符串转换成日期（yyyy-MM-dd）格式
     *
     * @param dateTime 时间字符串
     * @return String
     */
    public static String dateFormatToPattern(String dateTime, String pattern) {
        try {
            Date updateTime = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);

            //小于60 秒显示刚刚
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            String result = sf.format(updateTime);
            return result;
        } catch (Exception e) {
            log.error("时间转换错误, string = {}", e);
            return dateTime;
        }
    }

    /**
     * 将时间（yyyy-MM-dd HH:mm:ss）转换成日期（yyyy-MM-dd）
     *
     * @param dateTime 时间
     * @return Date
     * @throws ParseException
     */
    public static Date dateTimeToDate(Date dateTime) {
        if (dateTime == null) {
            return null;
        } else {
            try {
                return parseDate(formatDate(dateTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH:mm:ss）
     *
     * @return Date
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH:mm:ss）
     *
     * @return Date
     */
    public static Date dateTime() {
        return new Date();
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH:mm:ss）
     *
     * @return Date
     */
    public static Date getDateTime() {
        return dateTime();
    }

    /**
     * 获取当前日期（yyyy-MM-dd）
     *
     * @return Date
     * @throws ParseException
     */
    public static Date date() {
        return dateTimeToDate(new Date());
    }

    /**
     * 获取当前日期（yyyy-MM-dd）
     *
     * @return Date
     * @throws ParseException
     */
    public static Date getDate() {
        return date();
    }

    /**
     * 日期加减天数
     *
     * @param date 日期，为空时默认当前时间，包括时分秒
     * @param days 加减的天数
     * @return
     * @throws ParseException
     */
    public static Date dateAdd(Date date, int days) throws ParseException {
        if (date == null) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 日期加减分钟
     *
     * @param date   日期，为空时默认当前时间，包括时分秒
     * @param amount 加减的分钟
     * @return
     * @throws ParseException
     */
    public static Date subtractTime(Date date, int amount) throws ParseException {
        if (date == null) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, amount);
        return cal.getTime();
    }

    /**
     * 日期加减多少月
     *
     * @param date   日期，为空时默认当前时间，包括时分秒
     * @param months 加减的月数
     * @return
     * @throws ParseException
     */
    public static Date monthAdd(Date date, int months) throws ParseException {
        if (date == null) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }


    /**
     * 时间比较
     * <p>如果date大于compareDate返回1，小于返回-1，相等返回0</p>
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static int dateCompare(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Calendar compareCal = Calendar.getInstance();
        cal.setTime(date);
        //compareCal.setTime(date);
        return cal.compareTo(compareCal);
    }


    /**
     * 获取两个日期相差的天数，不包含今天
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int dateBetween(Date startDate, Date endDate) throws ParseException {
        if (ObjectUtil.isEmpty(startDate)
                || startDate == null
                || endDate == null
                || ObjectUtil.isEmpty(endDate)) {
            return 0;
        }
        Date dateStart = parse(format(startDate, DATE), DATE);
        Date dateEnd = parse(format(endDate, DATE), DATE);
        return (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24);
    }


    /**
     * 获取两个日期相差的天数，包含今天
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int dateBetweenIncludeToday(Date startDate, Date endDate) throws ParseException {
        return dateBetween(startDate, endDate) + 1;
    }


    public static void main(String[] args) {
       /* Date dateTime = DateUtils.getDateTime();
        System.out.println("昨日:" + dateTime.toString());
        System.out.println("昨日:" + DateUtils.getYesterday());

        System.out.println("本周:" + DateUtils.getCurrentWeekDays());

        System.out.println("本月:" + DateUtils.getCurrentMonthDays());

        System.out.println("本季度:" + DateUtils.getCurrentQuarterDays());

        System.out.println("近5天:" + DateUtils.getCustomDays(5));
        System.out.println("固定时间段:" + DateUtils.getFixedDays(LocalDate.now().minusDays(10), LocalDate.now()));
        System.out.println("固定时间段-string:" + DateUtils.getFixedDays("2023-04-02", "2023-04-04"));
        System.out.println(DateUtils.dateToWeek("2023-04-13"));*/

        System.out.println(DateUtils.dateFormatToPattern("2023-04-3", "M.d"));
        System.out.println(DateUtils.dateTimeToDate("2023-04-03 11:11:11"));
    }

    // 日期转星期
    public static String dateToWeek(String datetime) {
//        System.out.println(startDate.toString());
//        DayOfWeek dayOfWeek = startDate.getDayOfWeek();
//        System.out.println(dayOfWeek);
        String[] weekDays = {"日", "星期一", "星期二", "星期三", "星期四", "星期五", "六"};
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(datetime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1 < 0 ? 0 : cal.get(Calendar.DAY_OF_WEEK) - 1;
            String week = weekDays[w];
            return "六".equals(week) || "日".equals(week) ? week : new SimpleDateFormat("M-dd").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }

    // 昨日
    public static List<String> getYesterday() {
        String yesterday = LocalDate.now().minusDays(1).toString();
        return Collections.singletonList(yesterday);
    }

    // 本周 七天
    public static List<String> getCurrentWeekDays() {
        LocalDate now = LocalDate.now();
        // 周一
        LocalDate monday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        // 周日
        LocalDate sunday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        return getAscDateList(monday, sunday);
    }

    // 本月
    public static List<String> getCurrentMonthDays() {
        LocalDate now = LocalDate.now();
        // 本月1号
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        // 本月最后一天
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        return getAscDateList(firstDayOfMonth, lastDayOfMonth);
    }

    // 本季度
    public static List<String> getCurrentQuarterDays() {
        // 当前季度第一天
        LocalDate startOrStartDayOfQuarter = getStartOrEndDayOfQuarter(true);
        // 当前季度最后一天
        LocalDate startOrEndDayOfQuarter = getStartOrEndDayOfQuarter(false);
        return getAscDateList(startOrStartDayOfQuarter, startOrEndDayOfQuarter);
    }

    // 近几天
    public static List<String> getCustomDays(Integer nearDays) {
        LocalDate startDate = LocalDate.now().minusDays(1);
        LocalDate endDate = LocalDate.now().minusDays(nearDays);
        return getAscDateList(endDate, startDate);
    }

    // 固定时间段-string
    public static List<String> getFixedDays(String startDate, String endDate) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return getAscDateList(LocalDate.parse(startDate, fmt), LocalDate.parse(endDate, fmt));
    }

    // 固定时间段
    public static List<String> getFixedDays(LocalDate startDate, LocalDate endDate) {
        return getAscDateList(startDate, endDate);
    }

    /**
     * 获取 两个时间内 全部日期
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return {@link List}<{@link String}>
     */
    public static List<String> getAscDateList(LocalDate startDate, LocalDate endDate) {
        List<String> result = new ArrayList<>();
        if (endDate.compareTo(startDate) < 0) {
            return result;
        }
        while (true) {
            result.add(startDate.toString());
            if (startDate.compareTo(endDate) >= 0) {
                break;
            }
            startDate = startDate.plusDays(1);
        }
        return result;
    }

    /**
     * 季度开始或结束一天
     *
     * @param isFirst true 季度开始 false 季度结束
     * @return {@link LocalDate}
     */
    public static LocalDate getStartOrEndDayOfQuarter(Boolean isFirst) {
        LocalDate today = LocalDate.now();
        LocalDate resDate;
        Month month = today.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
        if (isFirst) {
            resDate = LocalDate.of(today.getYear(), firstMonthOfQuarter, 1);
        } else {
            resDate = LocalDate.of(today.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(today.isLeapYear()));
        }
        return resDate;
    }
}
