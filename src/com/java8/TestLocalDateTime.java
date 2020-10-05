package com.java8;

import javax.xml.transform.Source;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @package_name: com.java8
 * @name: TestLocalDateTime
 * @author: angenin
 * @dateTime: 2020/8/9 9:59 下午
 **/
public class TestLocalDateTime {

    public static void main(String[] args) {
        /*
            LocalDate：日期
            LocalTime：时间
            LocalDateTime：日期时间
            用法相同，只是专注点不同
        */

//        //获取当前时间
//        LocalDateTime ldt = LocalDateTime.now();
//        System.out.println(ldt);    //2020-08-09T22:19:45.912
//        //获取指定时间，2020-01-01 00:00:00
//        LocalDateTime ldt2 = LocalDateTime.of(2020, 1, 01, 00, 00, 00);
//        System.out.println(ldt2);   //2020-01-01T00:00
//
//        //plusXxx()方法为在当前时间上增加时间
//        LocalDateTime ldt3 = ldt2.plusYears(2);
//        System.out.println(ldt3);   //2022-01-01T00:00
//
//        System.out.println(ldt2.getYear());         //年 2020
//        System.out.println(ldt2.getMonthValue());   //月 1
//        System.out.println(ldt2.getDayOfMonth());   //日 1
//        System.out.println(ldt2.getHour());         //时 0
//        System.out.println(ldt2.getMinute());       //分 0
//        System.out.println(ldt2.getSecond());       //秒 0
//
//        //Instant：时间戳（以Unix元年(1970-01-01 00:00:00)到某个时间之间时间的毫秒值）
//        Instant instant = Instant.now();    //默认获取 UTC 时区
//        System.out.println(instant);    //2020-08-09T14:19:45.914Z
//
//        //偏移8个小时
//        OffsetDateTime odt = instant.atOffset(ZoneOffset.ofHours(8));
//        System.out.println(odt);    //2020-08-09T22:19:45.914+08:00
//
//        //转成毫秒时间戳
//        System.out.println(instant.toEpochMilli()); //1596983036271
//
//        Instant instant2 = Instant.ofEpochSecond(60);
//        System.out.println(instant2);   //1970-01-01T00:01:00Z
//
//        //Duration：计算两个"时间"的间隔
//        Instant ins1 = Instant.now();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Instant ins2 = Instant.now();
//        Duration duration = Duration.between(ins1, ins2);
//        System.out.println(duration.toMillis());
//
//        LocalTime lt1 = LocalTime.now();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        LocalTime lt2 = LocalTime.now();
//        Duration duration2 = Duration.between(lt1, lt2);
//        System.out.println(duration2.toMillis());
//
//
//        //Period：计算两个"日期"的间隔
//        LocalDate ld1 = LocalDate.of(2020, 1, 1);
//        LocalDate ld2 = LocalDate.now();
//        Period period = Period.between(ld1, ld2);
//        //相差7个月8天
//        System.out.println(period.getYears());  //0
//        System.out.println(period.getMonths()); //7
//        System.out.println(period.getDays());   //8


//        //TemporalAdjuster：时间校正器
//        LocalDateTime ldt = LocalDateTime.now();
//        System.out.println(ldt);    //2020-08-10T11:09:16.967
//
//        //withXxx()：
//        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
//        System.out.println(ldt2);   //2020-08-10T11:09:16.967
//
//        //返回下一个周日的日期时间
//        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
//        System.out.println(ldt3);   //2020-08-16T11:09:16.967
//
//        //自定义：返回下一个工作日的日期时间
//        LocalDateTime ldt5 = ldt.with((l) -> {
//            LocalDateTime ldt4 = (LocalDateTime) l;
//            //获取当前为周几
//            DayOfWeek dow = ldt4.getDayOfWeek();
//
//            //如果是周五，日期加上3天
//            if (dow.equals(DayOfWeek.FRIDAY)) {
//                return ldt4.plusDays(3);
//            } else if (dow.equals(DayOfWeek.FRIDAY)) {
//                //如果是周五，日期加上1天
//                return ldt4.plusDays(2);
//            } else {
//                //其他的加1天
//                return ldt4.plusDays(1);
//            }
//        });
//        System.out.println(ldt5);   //2020-08-11T11:17:36.618

//        //DateTimeFormatter：格式化时间/日期
//        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
//        LocalDateTime ldt = LocalDateTime.now();
//        //格式化日期
//        String strDate = ldt.format(dtf);
//        System.out.println(strDate);    //2020-08-10
//
//        //自定义：日期格式
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
//        String strDate2 = dtf2.format(ldt);
//        System.out.println(strDate2);   //2020年08月10日 11:24:53
//
//        //转换为原来的日期
//        LocalDateTime newDate = ldt.parse(strDate2, dtf2);
//        System.out.println(newDate);    //2020-08-10T11:27:28

        //ZonedDateTime

        //支持的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        //指定时区的日期时间
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(ldt);    //2020-08-10T12:34:06.619

        //指定时区的日期时间，返回带时区的日期时间
        LocalDateTime ldt2 = LocalDateTime.now();
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(zdt);    //2020-08-10T11:36:39.001+09:00[Asia/Tokyo]
    }

}
