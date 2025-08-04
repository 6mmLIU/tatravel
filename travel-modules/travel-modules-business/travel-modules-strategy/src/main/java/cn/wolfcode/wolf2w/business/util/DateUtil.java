package cn.wolfcode.wolf2w.business.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date getEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);//设置calendar为传入的日期时间
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static long getDateBetween(Date d1, Date d2) {
        return Math.abs(d1.getTime() - d2.getTime()) / 1000;
    }
}
