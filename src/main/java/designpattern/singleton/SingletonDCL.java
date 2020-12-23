package designpattern.singleton;

/**
 * 懒汉式，双重检验，比直接在方法上加锁的速度要快
 * 这种写法的优化处在于不用每次判断的时候都加上锁，当对象已经创建成功以后就不需要进行对象的创建，但是每次都会进行判断，所以这个判断就不需要加锁
 */
public class SingletonDCL {
    private static SingletonDCL singletonDCL;

    private SingletonDCL() {

    }

    public static SingletonDCL getInstance() {
        if (singletonDCL == null) {
            //大部分情况都是判断错误的，所以没必要再判断的时候进行上锁，这样可以增加代码运行的效率
            synchronized (SingletonDCL.class) {
                if (singletonDCL == null) {
                    singletonDCL = new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }
}
