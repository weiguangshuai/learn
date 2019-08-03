package concurrent.synchronizedtest;

public class SyncTest {
    public static void main(String[] args) {
        ObjectSyncThread objectSyncThread1 = new ObjectSyncThread();
//        ObjectSyncThread objectSyncThread2 = new ObjectSyncThread();

        Thread thread1 = new Thread(objectSyncThread1);
        Thread thread2 = new Thread(objectSyncThread1);
        thread1.start();
        thread2.start();

        ClassSyncThread classSyncThread1 = new ClassSyncThread();
        ClassSyncThread classSyncThread2 = new ClassSyncThread();
        Thread thread3 = new Thread(classSyncThread1);
        Thread thread4 = new Thread(classSyncThread2);
        thread3.start();
        thread4.start();

    }
}
