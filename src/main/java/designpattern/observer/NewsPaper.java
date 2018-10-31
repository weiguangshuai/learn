package designpattern.observer;

/**
 * @author weigs
 * @date 2018/6/18 0018
 */
public class NewsPaper extends Subject {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyObservers();
    }
}
