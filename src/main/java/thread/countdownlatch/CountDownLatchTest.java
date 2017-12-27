package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
 * 1、创建一个计数器，设置初始值，CountdownLatch countDownLatch = new CountDownLatch(2);
 * 2、在 等待线程 里调用 countDownLatch.await() 方法，进入等待状态，直到计数值变成 0；
 * 3、在 其他线程 里，调用 countDownLatch.countDown() 方法，该方法会将计数值减小 1；
 * 4、当 其他线程 的 countDown() 方法把计数值变成 0 时，等待线程 里的 countDownLatch.await() 立即退出，继续执行下面的代码。
 *
 * @author weigs
 * @date 2017/12/27 0027
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("D is working");
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println((char) ('A' + finalI) + " is working");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println((char) ('A' + finalI) + " finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
