package extendTest;

public class Test1 {

    public String s1;

    private String s2;

    public void f1() {
        System.out.println("method f1");
    }

    public void g1() {
        f1();
        System.out.println("method g1");
    }
}
