package designpattern.flyweight;

/**
 * @author weigs
 * @date 2018/3/6 0006
 */
public class Circle extends Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("画了一个" + color + "的圆形");
    }
}
