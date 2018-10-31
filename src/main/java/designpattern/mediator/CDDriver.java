package designpattern.mediator;

/**
 * @author weigs
 * @date 2018/6/17 0017
 */
public class CDDriver extends Colleague {
    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    //光盘读取出来的数据
    private String data = "";

    public String getData() {
        return data;
    }

    /**
     * 读取光盘
     */
    public void readCD() {
        this.data = "中介者模式视频,中介者模式音频";
        //通知主板，自己的状态发生了改变
        this.getMediator().change(this);
    }

}
