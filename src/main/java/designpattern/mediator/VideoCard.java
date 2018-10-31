package designpattern.mediator;

/**
 * @author weigs
 * @date 2018/6/17 0017
 */
public class VideoCard extends Colleague {
    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    public void showData(String data) {
        System.out.println("正在观看"+data);
    }
}
