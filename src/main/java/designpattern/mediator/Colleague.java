package designpattern.mediator;

/**
 * @author weigs
 * @date 2018/6/17 0017
 */
public abstract class Colleague {
    //持有中介者对象，每一个同事类都知道它的中介者对象
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
}
