package designpattern.abstractfactory;

/**
 * @author weigs
 * @date 2018/2/28 0028
 */
public abstract class AbstractFactory {
    public abstract AbstractProduct createMouse();

    public abstract AbstractProduct createKey();
}
