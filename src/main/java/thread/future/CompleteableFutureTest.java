package thread.future;

import java.util.concurrent.CompletableFuture;

public class CompleteableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() ->
        {
            System.out.println("T1:洗水壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("T1:烧开水");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("T2:洗茶壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2:洗茶杯");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2:拿茶叶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "铁观音";
        });

        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T3:泡茶");
            return "上茶：" + tf;
        });

        System.out.println(f3.join());
    }
}
