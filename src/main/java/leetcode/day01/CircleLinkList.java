package leetcode.day01;

/**
 * 判断一个链表是不是环形链表
 * 思路：两个快慢指针分别在链表上面运动，快指针速度为2，慢指针速度为1，如果是环形的链表，总有碰面的时候
 */
public class CircleLinkList {

    public static void main(String[] args) {
        Node linkList = new Node(1);
        Node node1 = new Node(2);
        linkList.next = node1;
        node1.next = linkList;
        boolean b = checkCircle(linkList);
        System.out.println(b);
    }

    public static boolean checkCircle(Node firstNode) {
        Node slow = firstNode;
        Node fast = firstNode.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
