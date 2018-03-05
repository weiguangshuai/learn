package designpattern.facade;

/**
 * @author weigs
 * @date 2018/3/5 0005
 */
public class Client {
    public static void main(String[] args) {
        PrimarySystem system = new PrimarySystem();
        system.methodOne();
        system.methodTwo();
    }
}
