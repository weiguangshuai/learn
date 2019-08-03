package effectivejava.chapter02;

import java.util.Date;

public class PersonTest {
    public static void main(String[] args) {
        //同时调用一千万次，查看结果
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Person person = new Person();
            person.setBirthDate(new Date());
            person.isBaby();
        }
        System.out.println("Person : " + (System.currentTimeMillis() - start));

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            PersonPro person = new PersonPro();
            person.setBirthDate(new Date());
            person.isBaby();
        }
        System.out.println("PersonPro : " + (System.currentTimeMillis() - begin));
    }
}
