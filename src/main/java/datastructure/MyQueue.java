package datastructure;

/**
 * 模拟队列
 */
public class MyQueue {

    //队列中不能够存满，所以要留一个空位，13个数组实际只有12个能够存储
    private int[] queue = new int[13];

    //队列的头指向的数组下标
    private int head = 0;

    //队列下一个数据插入指向的下标
    private int tail = 0;

    private int size = 0;

    public void enqueue(int node) {
        //判断是否为空，head和tail相等，代表为空
        if (head == tail) {
            queue[head] = node;
            if (tail == queue.length - 1) {
                tail = 0;
            }
            tail = tail + 1;
            return;
        }
        //判断队列是否满了
        if ((tail + 1) == head || (tail == queue.length - 1 && head == 0)) {
            throw new RuntimeException("队列已经满了（上溢）");
        }
        queue[tail] = node;
        if (tail == queue.length - 1) {
            tail = 0;
        }
        tail = tail + 1;
    }

    public int dequeue() {
        //判断队列中是否还有数据
        if (head == tail) {
            throw new RuntimeException("队列空了，没有数据取出（下溢）");
        }
        int result = queue[head];
        if (head == queue.length - 1) {
            head = 0;
        } else {
            head = head + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < 12; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 12; i++) {
            queue.dequeue();
            System.out.println(queue.head);
            System.out.println(queue.tail);
            System.out.println("-----------------------");
        }
        queue.enqueue(1);
        System.out.println(queue.head);
        System.out.println(queue.tail);
        System.out.println("-----------------------");


    }
}
