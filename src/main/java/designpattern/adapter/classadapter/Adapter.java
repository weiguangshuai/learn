package designpattern.adapter.classadapter;

/**
 * @author weigs
 * @date 2018/3/1 0001
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void fun2() {
        System.out.println("Target Fun2");
    }
}
