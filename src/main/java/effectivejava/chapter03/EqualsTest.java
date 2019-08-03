package effectivejava.chapter03;

public class EqualsTest {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));

        ColorPoint c1 = new ColorPoint(1, 2, "red");
        ColorPoint c2 = new ColorPoint(1, 2, "red");
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c1));

        System.out.println(p1.equals(c1));
        System.out.println(c1.equals(p1));
    }
}
