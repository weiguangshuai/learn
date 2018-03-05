package designpattern.decorator;

/**
 * @author weigs
 * @date 2018/3/5 0005
 */
public class AirPlane extends Changer{
    public AirPlane(Transform transform) {
        super(transform);
    }

    @Override
    public void move() {
        super.move();
    }

    public void fly() {
        System.out.println("I can fly");
    }
}
