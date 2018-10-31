package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weigs
 * @date 2018/6/18 0018
 */
public class Subject {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> readers = new ArrayList<>();

    /**
     * 读者向报社订阅
     * @param reader
     */
    public void attach(Observer reader) {
        readers.add(reader);
    }

    /**
     * 读者取消订阅
     * @param reader
     */
    public void detach(Observer reader) {
        readers.remove(reader);
    }

    protected void notifyObservers() {
        for (Observer observer : readers) {
            observer.update(this);
        }
    }
}
