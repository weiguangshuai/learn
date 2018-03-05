package designpattern.facade;

/**
 * 外观模式
 *
 * @author weigs
 * @date 2018/3/5 0005
 */
public class PrimarySystem {
    private SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;

    public PrimarySystem() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
        subSystemC = new SubSystemC();
    }

    public void methodOne() {
        subSystemA.MethodA();
        subSystemC.MethodC();
    }

    public void methodTwo() {
        subSystemA.MethodA();
        subSystemB.MethodB();
        subSystemC.MethodC();
    }
}
