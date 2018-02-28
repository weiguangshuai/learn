package designpattern.abstractfactory;

/**
 * @author weigs
 * @date 2018/2/28 0028
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractProduct asusKey = new AsusFactory().createKey();
        asusKey.use();
        AbstractProduct asusMouse = new AsusFactory().createMouse();
        asusMouse.use();

        AbstractProduct lenovoKey = new LenovoFactory().createKey();
        lenovoKey.use();
        AbstractProduct lenovoMouse = new LenovoFactory().createMouse();
        lenovoMouse.use();
    }
}
