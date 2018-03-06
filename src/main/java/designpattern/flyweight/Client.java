package designpattern.flyweight;

/**
 * @author weigs
 * @date 2018/3/6 0006
 */
public class Client {
    public static void main(String[] args) {
        Shape shape1 = FlyWeightFactory.getInstance("red");
        shape1.draw();
        Shape shape2 = FlyWeightFactory.getInstance("green");
        shape2.draw();
        Shape shape3 = FlyWeightFactory.getInstance("red");
        shape3.draw();
        System.out.println(FlyWeightFactory.getNum());
    }
}
