package concurrent.notify;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                car.waitForWaxing();
                System.out.println("Wax off !");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
