package effectivejava.chapter03;

public class ColorPoint extends Point {
    private final String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && ((ColorPoint) obj).color.equals(color);
    }
}
