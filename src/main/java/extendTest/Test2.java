package extendTest;

import java.lang.reflect.Field;

public class Test2 extends Test1 {
    public void f1() {
        System.out.println("test2 method f1");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String str = "weigs";
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        System.out.println(stringBuilder.toString());

        Class clazz = Class.forName("extendTest.Test1");
        Test1 test1 = (Test1) clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            field.setAccessible(true);
            field.set(test1, "weigs");
        }
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.get(test1));
        }

    }
}
