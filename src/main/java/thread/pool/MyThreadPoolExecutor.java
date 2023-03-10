package thread.pool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolExecutor {

    //存放线程的集合
    private ArrayList<Worker> threadPool;

    //任务队列
    private ArrayBlockingQueue<Runnable> taskQueue;

    private int maxThread;

    private AtomicInteger workThread;

    private ReentrantLock lock = new ReentrantLock();


    public MyThreadPoolExecutor(int maxThread) {
        this.maxThread = maxThread;
        workThread = new AtomicInteger(0);
        threadPool = new ArrayList<>();
        taskQueue = new ArrayBlockingQueue<>(10);
    }


    public void execute(Runnable runnable) {
        //线程池未满，创建一个线程
        if (workThread.get() < maxThread) {
            startWorker(runnable);
        } else {
            //线程池已经满了，将任务放到队列中去
            taskQueue.add(runnable);
        }
    }

    private void startWorker(Runnable runnable) {
        lock.lock();
        try {
            if (workThread.get() < maxThread) {
                Worker worker = new Worker(runnable);
                worker.start();
                threadPool.add(worker);
                workThread.incrementAndGet();
            } else {
                taskQueue.add(runnable);
            }
        } finally {
            lock.unlock();
        }

    }


    class Worker extends Thread {
        private Runnable runnable;

        public Worker(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            //一直启动，不断从任务队列中取出任务
            while (true) {
                //如果初始化时有任务，执行任务
                if (runnable != null) {
                    runnable.run();
                    runnable = null;
                }
                //否则去任务队列中取任务并执行
                else {
                    Runnable queueTask = null;
                    try {
                        queueTask = taskQueue.take();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (queueTask != null) {
                        queueTask.run();
                    }
                }
            }
        }
    }

}
