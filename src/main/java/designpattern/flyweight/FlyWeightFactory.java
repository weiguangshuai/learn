package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weigs
 * @date 2018/3/6 0006
 */
public class FlyWeightFactory {
    private static Map<String, Shape> shapes = new HashMap<>();

    public static Shape getInstance(String key) {
        Shape shape = shapes.get(key);
        if (shape == null) {
            shape = new Circle(key);
            shapes.put(key, shape);
        }
        return shape;
    }

    public static int getNum() {

        return shapes.size();
    }

}
