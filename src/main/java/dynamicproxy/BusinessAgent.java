package dynamicproxy;

public class BusinessAgent implements Sell {
    @Override
    public void sell() {
        System.out.println("In sell method");
    }

    @Override
    public void ad() {
        System.out.println("ad method");
    }
}
