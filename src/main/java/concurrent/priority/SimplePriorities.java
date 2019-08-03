package concurrent.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 优先级
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        //为当前线程设置优先级
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
            executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        }
        executorService.shutdown();
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
}
