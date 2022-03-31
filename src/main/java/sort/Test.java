package sort;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        int busyTime = 10;
        int idleTime = busyTime;

        while (true) {
            long startTime = System.currentTimeMillis();
            //busy loop:
            while ((System.currentTimeMillis() - startTime) <= busyTime)
                ;
            Thread.sleep(idleTime);
        }
    }
}
