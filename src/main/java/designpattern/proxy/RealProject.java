package designpattern.proxy;

/**
 * @author weigs
 * @date 2018/3/9 0009
 */
public class RealProject implements Subject {
    @Override
    public void request() {
        System.out.println("real request");
    }
}
