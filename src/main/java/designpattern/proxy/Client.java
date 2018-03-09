package designpattern.proxy;

/**
 * @author weigs
 * @date 2018/3/9 0009
 */
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealProject());
        proxy.request();
    }
}
