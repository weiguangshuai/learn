package designpattern.adapter.objectadapter;

/**
 * 适配器类
 *
 * @author weigs
 * @date 2018/3/1 0001
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void fun1() {
        adaptee.sampleFun1();
    }

    @Override
    public void fun2() {
        System.out.println("Target Fun2");
    }
}
