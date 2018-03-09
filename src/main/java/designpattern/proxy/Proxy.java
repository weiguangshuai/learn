package designpattern.proxy;

/**
 * @author weigs
 * @date 2018/3/9 0009
 */
public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("pre real request");
        subject.request();
        System.out.println("post real request");
    }
}
