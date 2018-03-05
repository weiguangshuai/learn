package designpattern.decorator;

/**
 * 装饰模式
 *
 * @author weigs
 * @date 2018/3/5 0005
 */
public class Client {
    public static void main(String[] args) {
        Transform transform = new Car();
        Robot robot = new Robot(transform);
        robot.move();
        robot.say();

        AirPlane airPlane = new AirPlane(transform);
        airPlane.move();
        airPlane.fly();
    }
}
