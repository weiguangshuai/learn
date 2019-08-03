package concurrent.chapter1;

/**
 * 测试并发和非并发的运行时间
 */
public class ConcurrentTest {

    private static final long count = 100000001;

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        serial();
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        concurrency();
        long end2 = System.currentTimeMillis();
        System.out.println("time1:" + (end2 - start2));

    }

    private static void serial() {

        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        System.out.println("b=" + b + ",a=" + a);
    }

    private static void concurrency() {
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        System.out.println("b=" + b);
    }

}
