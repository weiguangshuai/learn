package concurrent.synchronizedtest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectSyncThread implements Runnable {
    @Override
    public void run() {
//        syncCodeBlock();
        syncMethod();
    }

    private void syncCodeBlock() {
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + "_Sync_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "_Sync_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void syncMethod() {
        System.out.println(Thread.currentThread().getName() + "_Sync_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "_Sync_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

    }

}
