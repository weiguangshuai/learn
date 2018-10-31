package designpattern.command;

/**
 * @author weigs
 * @date 2018/6/16 0016
 */
public class OpenCommand implements Command{

    private Receiver receiver;

    public OpenCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
