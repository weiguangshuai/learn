package thread.join;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName());
    }
}
