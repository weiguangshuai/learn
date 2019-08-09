package concurrent.performance;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weigs
 * @date 2019/8/9 0009
 */
public class SynchronizationComparisons {
}

/**
 * 模板模式
 */
abstract class Accumulator {
    public static long cycles = 5000L;
    //每个测试的修改者和测试者个数
    private static final int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 10000;
    protected static int[] preLoaded = new int[SIZE];

    static {
        Random random = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preLoaded[i] = random.nextInt();
        }
    }

    public abstract void accumulate();

    public abstract long read();

    private class Modifier implements Runnable {

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                accumulate();
            }
            try {
                barrier.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Reader implements Runnable {

        private volatile long value;

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                value = read();
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void timeTest() {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        duration = System.nanoTime() - start;
        System.out.println("id: " + id + " duration: " + duration);
    }

    public static void report(Accumulator accumulator, Accumulator accumulator1) {
        System.out.println(accumulator.id + "/" + accumulator1.id + "rate:" + accumulator.duration / accumulator1.duration);
    }
}

class BaseLine extends Accumulator {

    {
        id = "BaseLine";
    }

    @Override
    public void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    @Override
    public long read() {
        return value;
    }

}

class SynchronizedTest extends Accumulator {

    {
        id = "synchronized";
    }

    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class LockTest extends Accumulator {

    @Override
    public void accumulate() {

    }

    @Override
    public long read() {
        return 0;
    }
}

