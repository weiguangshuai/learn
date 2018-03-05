package designpattern.decorator;

/**
 * @author weigs
 * @date 2018/3/5 0005
 */
public class Car implements Transform {
    @Override
    public void move() {
        System.out.println("car move");
    }
}
