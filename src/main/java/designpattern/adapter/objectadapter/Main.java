package designpattern.adapter.objectadapter;

/**
 * @author weigs
 * @date 2018/3/1 0001
 */
public class Main {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Adaptee());
        adapter.fun1();
        adapter.fun2();
    }
}
