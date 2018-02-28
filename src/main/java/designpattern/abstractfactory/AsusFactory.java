package designpattern.abstractfactory;

/**
 * @author weigs
 * @date 2018/2/28 0028
 */
public class AsusFactory extends AbstractFactory {
    @Override
    public AbstractProduct createMouse() {
        return new AsusMouseProduct();
    }

    @Override
    public AbstractProduct createKey() {
        return new AsusKeyProduct();
    }
}
