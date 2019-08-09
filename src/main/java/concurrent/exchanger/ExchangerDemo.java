package concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author weigs
 * @date 2019/8/9 0009
 */
public class ExchangerDemo {
    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(() -> {
            try {
                String boy = exchanger.exchange("boy");
                System.out.println("boy: " + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        exec.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                String girl = exchanger.exchange("girl");
                System.out.println("girl: " + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
