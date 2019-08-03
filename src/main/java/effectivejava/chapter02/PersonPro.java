package effectivejava.chapter02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 没有重复创建Date的类
 */
public class PersonPro {
    private Date birthDate;
    private static final Date START;
    private static final Date END;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(2019, Calendar.MAY, 1, 0, 0, 0);
        START = calendar.getTime();
        calendar.set(2019, Calendar.MAY, 3, 0, 0, 0);
        END = calendar.getTime();
    }

    public boolean isBaby() {
        return birthDate.compareTo(START) >= 0 && birthDate.compareTo(END) < 0;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
