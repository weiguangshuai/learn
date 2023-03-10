package thread.pool;

public class Test {
    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(2);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
