package datastructure;

public class MyLinkedList<V> {

    private Node<V> head;

    private Node<V> tail;

    public MyLinkedList() {

    }

    //插入
    public void put(V value) {
        Node<V> node = new Node<>(value);
        insert(node);
    }

    private void insert(Node<V> node) {
        //判断链表是否为空
        if (this.head == null) {
            //证明是空链表,插入第一个对象；头部和尾部都指向刚才这个插入的数据
            head = node;
            tail = node;
        }
        //不为空采用头插法
        head.pre = node;
        node.next = head;
        head = node;
    }

    //删除
    public V delete(V v) {
        Node<V> temp = head;
        Node<V> prev, next;
        while (temp != null) {
            if (temp.getValue() == v) {
                prev = temp.pre;
                next = temp.next;
                //删除的主要逻辑
                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }
                if (next != null) {
                    next.pre = prev;
                }
                break;
            }
            temp = temp.next;
        }

        if (temp != null) {
            return temp.getValue();
        }
        return null;
    }


    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.put("ssss");
        linkedList.put("aaa");

        String aaa = linkedList.delete("aaa");
        System.out.println(aaa);

    }

    static class Node<V> {

        private V value;

        private Node<V> pre;

        private Node<V> next;

        public Node(V value) {
            this.value = value;
            pre = null;
            next = null;
        }

        public V getValue() {
            return value;
        }
    }


}
