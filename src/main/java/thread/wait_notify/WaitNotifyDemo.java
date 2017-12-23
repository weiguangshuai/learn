package thread.wait_notify;

/**
 * wait_notify实现线程之间通信：让两个线程按照指定方式有序交叉运行
 *
 * @author weigs
 * @date 2017/12/22 0022
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread A = new Thread(() -> {
            synchronized (lock) {
                System.out.println("A 1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A 2");
                System.out.println("A 3");
            }
        });

        Thread B = new Thread(() -> {
            synchronized (lock) {
                System.out.println("B 1");
                System.out.println("B 2");
                System.out.println("B 3");
                lock.notify();
            }
        });
        A.start();
        B.start();
    }
}
