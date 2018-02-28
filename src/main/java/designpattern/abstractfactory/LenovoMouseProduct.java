package designpattern.abstractfactory;

/**
 * @author weigs
 * @date 2018/2/28 0028
 */
public class LenovoMouseProduct extends MouseProduct {
    @Override
    public void use() {
        System.out.println("Lenovo mouse");
    }
}
