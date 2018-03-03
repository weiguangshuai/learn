package designpattern.bridge;

/**
 * @author weigs
 * @date 2018/3/3 0003
 */
public class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.print("长方形");
    }
}
