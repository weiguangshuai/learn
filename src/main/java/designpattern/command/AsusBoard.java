package designpattern.command;

/**
 * 主板相当于接受者对象，华硕主板
 * @author weigs
 * @date 2018/6/16 0016
 */
public class AsusBoard implements Receiver {
    @Override
    public void action() {
        System.out.println("华硕主板现在正在开机，请等候");
        System.out.println("接通电源......");
        System.out.println("设备检查......");
        System.out.println("装载系统......");
        System.out.println("机器正常运转起来......");
        System.out.println("机器已经正常打开，请操作");
    }
}
