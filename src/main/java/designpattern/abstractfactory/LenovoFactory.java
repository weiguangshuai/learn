package designpattern.abstractfactory;

/**
 * @author weigs
 * @date 2018/2/28 0028
 */
public class LenovoFactory extends AbstractFactory {
    @Override
    public AbstractProduct createMouse() {
        return new LenovoMouseProduct();
    }

    @Override
    public AbstractProduct createKey() {
        return new LenovoKeyProduct();
    }
}
