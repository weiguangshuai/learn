package effectivejava.chapter02;

/**
 * 装箱对象对性能的影响
 */
public class BinningTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("long : " + (System.currentTimeMillis() - start));

        long begin = System.currentTimeMillis();
        Long count = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            count += i;
        }
        System.out.println("Long : " + (System.currentTimeMillis() - begin));
    }
}
