package designpattern.command;

/**
 * @author weigs
 * @date 2018/6/16 0016
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new MSIBoard();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.runCommand();
    }
}
