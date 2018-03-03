package designpattern.bridge;

/**
 * @author weigs
 * @date 2018/3/3 0003
 */
public abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public void draw() {
        System.out.print("画出");
        color.paint();

    }
}
