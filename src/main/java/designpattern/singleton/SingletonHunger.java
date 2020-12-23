package designpattern.singleton;

/**
 * 饿汉式
 */
public class SingletonHunger {
    private static SingletonHunger singletonHunger = new SingletonHunger();

    private SingletonHunger() {

    }

    public static SingletonHunger getInstance() {
        return singletonHunger;
    }

}

class Mytest {
    public static void main(String[] args) {
        SingletonHunger single = SingletonHunger.getInstance();
        System.out.println(single);
    }
}
