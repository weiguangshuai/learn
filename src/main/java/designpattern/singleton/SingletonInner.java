package designpattern.singleton;

/**
 * 使用静态内部类来实现
 */
public class SingletonInner {
    private static class Single {
        private static final SingletonInner INSTANCE = new SingletonInner();
    }

    private SingletonInner() {
    }


    public static SingletonInner getInstance() {
        return Single.INSTANCE;
    }
}
