package designpattern.bridge;

/**
 * @author weigs
 * @date 2018/3/3 0003
 */
public class RedColor implements Color {
    @Override
    public void paint() {
        System.out.print("红色");
    }
}
