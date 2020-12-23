package designpattern.singleton;

/**
 * 懒汉式，线程安全
 */
public class SingletonLazySave {
    private static SingletonLazySave singletonLazySave;

    private SingletonLazySave() {

    }

    public static synchronized SingletonLazySave getInstance() {
        if (singletonLazySave == null) {
            singletonLazySave = new SingletonLazySave();
        }
        return singletonLazySave;
    }
}

class test {
    public static void main(String[] args) {
        SingletonLazySave singletonLazySave = SingletonLazySave.getInstance();
        System.out.println(singletonLazySave);
    }
}
