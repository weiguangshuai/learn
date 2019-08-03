package effectivejava.chapter02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 大量常见Date类的对象
 */
public class Person {
    private Date birthDate;

    public boolean isBaby() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(2019, Calendar.MAY, 1, 0, 0, 0);
        Date start = calendar.getTime();
        calendar.set(2019, Calendar.MAY, 3, 0, 0, 0);
        Date end = calendar.getTime();
        return birthDate.compareTo(start) >= 0 && birthDate.compareTo(end) < 0;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
