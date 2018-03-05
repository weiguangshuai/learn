package designpattern.decorator;

/**
 * @author weigs
 * @date 2018/3/5 0005
 */
public abstract class Changer implements Transform {
    private Transform transform;

    public Changer(Transform transform) {
        this.transform = transform;
    }

    @Override
    public void move() {
        transform.move();
    }
}
