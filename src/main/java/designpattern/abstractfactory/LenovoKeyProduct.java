package designpattern.abstractfactory;

/**
 * @author weigs
 * @date 2018/2/28 0028
 */
public class LenovoKeyProduct extends KeyProduct {
    @Override
    public void use() {
        System.out.println("Lenovo key");
    }
}
