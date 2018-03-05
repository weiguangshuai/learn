package designpattern.decorator;

/**
 * @author weigs
 * @date 2018/3/5 0005
 */
public class Robot extends Changer {
    public Robot(Transform transform) {
        super(transform);
    }

    public void say() {
        System.out.println("I can speak");
    }

    @Override
    public void move() {
        super.move();
    }
}
