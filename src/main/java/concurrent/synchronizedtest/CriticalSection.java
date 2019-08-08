package concurrent.synchronizedtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {

    static void testApproches(PairManager pairManager1, PairManager pairManager2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator manipulator1 = new PairManipulator(pairManager1);
        PairManipulator manipulator2 = new PairManipulator(pairManager2);

        PairChecker pairChecker1 = new PairChecker(pairManager1);
        PairChecker pairChecker2 = new PairChecker(pairManager2);

        exec.execute(manipulator1);
        exec.execute(manipulator2);

        exec.execute(pairChecker1);
        exec.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }

        System.out.println("PairManipulator1: " + manipulator1 + "\nPairManipulator2: " + manipulator2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pairManager1 = new PairManager1();
        PairManager pairManager2 = new PairManager2();
        testApproches(pairManager1, pairManager2);
    }
}
