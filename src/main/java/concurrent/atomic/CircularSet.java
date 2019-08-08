package concurrent.atomic;

public class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int item) {
        for (int i = 0; i < len; i++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }
}
