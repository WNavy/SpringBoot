import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: wuhaijun
 * @Date: 2019/5/14 14:09
 * @Description: jdk8的一些特性分析
 */
public class Jdk8FeatureTest {

    @Test
    public void useDate(){

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate：" + localDate);
        LocalDate local2Date1 = localDate.minusDays(2);
        System.out.println("local2Date1：" + local2Date1);


        LocalTime localTime = LocalTime.now();
        System.out.println("localTime：" + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime：" + localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String result = localDateTime.format(formatter);
        System.out.println("result :" + result);
        LocalDateTime from = LocalDateTime.from(formatter.parse("1993/11/25 12:00:15"));
        System.out.println("from :" + from);

        OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.ofHours(8));
        Instant instant = offsetDateTime.toInstant();
        System.out.println("instant:" + instant);

        Date date = Date.from(instant);
        System.out.println("Date:" + date);
    }
}
