package designpattern.command;

/**
 * 具体命令实现对象
 * @author weigs
 * @date 2018/6/16 0016
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
