package designpattern.mediator;

/**
 * @author weigs
 * @date 2018/6/17 0017
 */
public class SoundCard extends Colleague {
    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    public void showData(String data) {
        System.out.println("正在收听"+data);
    }
}
