package designpattern.observer;

/**
 * @author weigs
 * @date 2018/6/18 0018
 */
public class Reader implements Observer {
    private String name;

    @Override
    public void update(Subject subject) {
        System.out.println(name+"收到报纸，内容为："+((NewsPaper)subject).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
