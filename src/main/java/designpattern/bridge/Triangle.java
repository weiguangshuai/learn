package designpattern.bridge;

/**
 * @author weigs
 * @date 2018/3/3 0003
 */
public class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }

    public void draw() {
        super.draw();
        System.out.print("三角形");
    }
}
