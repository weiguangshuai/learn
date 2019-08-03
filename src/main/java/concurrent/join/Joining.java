package concurrent.join;

public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy", 15000);
        Sleeper grumpy = new Sleeper("Grumpy", 15000);

        Joiner dopey = new Joiner("Dopey", sleeper);
        Joiner doc = new Joiner("Doc", grumpy);

        //对join()方法的中断，在调用线程上调用该方法
        grumpy.interrupt();
    }
}
