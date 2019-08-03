package concurrent.synchronizedtest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassSyncThread implements Runnable {

    @Override
    public void run() {
        syncCodeBlock();
    }

    public void syncCodeBlock() {
        synchronized (ClassSyncThread.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "_Sync_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "_Sync_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
