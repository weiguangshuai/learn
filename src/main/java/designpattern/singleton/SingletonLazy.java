package designpattern.singleton;

/**
 * 懒汉式，线程不安全
 */
public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() throws InterruptedException {
        Thread.sleep(1000);
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

    @Override
    public String toString() {
        return String.valueOf(super.hashCode());
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singletonLazy);
        System.out.println(singletonLazy1);
        System.out.println(singletonLazy2);

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                SingletonLazy singletonLazy3 = null;
                try {
                    singletonLazy3 = SingletonLazy.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(singletonLazy3);
            }).start();
        }
    }
}