package thread.lock;

/**
 * 模拟死锁
 *
 * @author weigs
 * @date 2017/12/27 0027
 */
public class DeadLock {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("A1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("A2");
                    }
                }
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("B1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("B2");

                    }
                }
            }
        });
        A.start();
        B.start();
    }
}
