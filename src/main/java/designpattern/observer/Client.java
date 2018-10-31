package designpattern.observer;

/**
 * @author weigs
 * @date 2018/6/18 0018
 */
public class Client {
    public static void main(String[] args) {
        NewsPaper subject = new NewsPaper();
        //创建阅读者，也就是观察者
        Reader reader1 = new Reader();
        reader1.setName("张三");

        Reader reader2 = new Reader();
        reader2.setName("李四");

        Reader reader3 = new Reader();
        reader3.setName("王五");

        //注册阅读者
        subject.attach(reader1);
        subject.attach(reader2);
        subject.attach(reader3);

       subject.setContent("观察者模式");
    }
}
