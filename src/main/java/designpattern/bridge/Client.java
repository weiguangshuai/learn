package designpattern.bridge;

/**
 * 桥接模式
 *
 * @author weigs
 * @date 2018/3/3 0003
 */
public class Client {
    public static void main(String[] args) {
        Color color = new RedColor();
        Shape rectangle = new Rectangle(color);
        rectangle.draw();
        color = new GreenColor();
        rectangle = new Rectangle(color);
        rectangle.draw();
    }
}
