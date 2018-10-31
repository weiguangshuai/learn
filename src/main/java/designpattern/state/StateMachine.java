package designpattern.state;

/**
 * 公共状态处理机，相当于状态模式的Context
 *
 * @author weigs
 * @date 2018/6/19 0019
 */
public class StateMachine {
    private State state;

    private Object businessVO;

    public void doWork() {
        state.doWork();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Object getBusinessVO() {
        return businessVO;
    }

    public void setBusinessVO(Object businessVO) {
        this.businessVO = businessVO;
    }
}
