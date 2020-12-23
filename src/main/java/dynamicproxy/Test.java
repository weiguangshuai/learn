package dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new BusinessAgent());
        Sell sell = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(),
                new Class[]{Sell.class}, dynamicProxy);
        sell.sell();
        sell.ad();
    }
}
