package designpattern.command;

/**
 * 调用者（调用命令对象）
 * @author weigs
 * @date 2018/6/16 0016
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        command.execute();
    }
}
