package datastructure;

import java.util.Stack;

/**
 * 二叉搜索树实现
 * 主要功能如下：
 * 1、三种遍历的递归实现和非递归实现
 * 2、插入节点
 * 3、二叉搜索树的最小节点
 * 4、删除节点
 *
 * @param <V>
 */
public class MyTree<V> {

    private Node<V> root;


    //插入二叉搜索树节点
    public void insertNode(Node<V> node) {
        Node<V> tmp, result = null;
        tmp = root;
        //找到新的数据需要插入的节点，用result来表示，tmp表示的是寻找插入节点时的临时存放节点的值
        while (tmp != null) {
            result = tmp;
            if (node.i < tmp.i) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }

        //设置父节点
        node.parent = result;

        //如果为空，则代表整个树是空的
        if (result == null) {
            root = node;
        } else if (node.i < result.i) {
            result.left = node;
        } else {
            result.right = node;
        }
    }


    //删除二叉搜索树节点
    //考虑到三种情况
    //1、要删除的节点没有子节点，直接删除，修改删除节点的父节点即可
    //2、要删除的节点只有一个节点，删除该节点，并将其子节点提升到其位置上，修改父节点
    //3、要删除的节点有两个节点，删除该节点，并将其右节点提升到其位置，期间要考虑右节点有没有左孩子节点的情况，要具体分析

    //代码思路：
    // 1、定义一个函数，用来将一个以A为根的子树替换成一个以B为根的子树
    // 2、先处理左节点为null的情况，再处理右节点为null的情况，最后处理两个节点都不为空的情况
    // 3、在都不为null的情况下，首先找到要删除节点的右子树中最小的节点，如果最小节点的父节点为要删除节点，则直接用最小节点替换要删除的节点
    // 4、如果最小节点的父节点不是要删除的节点，则需要将最小节点的右子树（最小节点没有左子树）放到最小节点的父节点上（用右子树的根节点替换最小节点）
    // 然后用最小节点来替换要删除的节点
    public void deleteNode(Node<V> node) {
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            Node<V> minNode = minNode(node.right);
            //判断最小的节点的父节点是否为要删除的节点
            if (minNode.parent != node) {
                transplant(minNode, minNode.right);
                minNode.right = node.right;
                minNode.right.parent = minNode;
            }
            transplant(node, minNode);
            minNode.left = node.left;
            minNode.left.parent = minNode;
        }
    }

    //用newNode替换origin节点
    private void transplant(Node<V> origin, Node<V> newNode) {
        //判断是否为根节点
        if (origin.parent == null) {
            root = newNode;
        }
        //判断原始节点是左节点还是右节点
        else if (origin.parent.left == origin) {
            origin.parent.left = newNode;
        } else if (origin.parent.right == origin) {
            origin.parent.right = newNode;
        }

        //允许传入的新节点为null
        if (newNode != null) {
            origin.parent = newNode.parent;
        }
    }


    //找出一个二叉树最小的节点
    public Node<V> minNode(Node<V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //先序遍历，先输出该节点的值，再继续遍历左右子树（根左右），所谓的先序，这个序就是看根节点的序列
    //递归方法
    public void preorderTraversalWithRecursion(Node<V> node) {
        if (node != null) {
            System.out.println(node.value);
            preorderTraversalWithRecursion(node.left);
            preorderTraversalWithRecursion(node.right);
        }

    }

    //先序遍历，不使用递归遍历的方法
    public void preorderTraversal(Node<V> node) {
        Stack<Node<V>> treeStack = new Stack<>();
        while (node != null || !treeStack.isEmpty()) {
            while (node != null) {
                //先序遍历，先输出根节点
                System.out.println(node.getValue());
                //为了后续找到右节点，先存起来
                treeStack.push(node);
                node = node.left;
            }

            //一直到左树为空，最后一个节点也放到了栈里面
            //开始遍历右子树
            if (!treeStack.isEmpty()) {
                node = treeStack.pop();
                node = node.right;
            }
        }
    }

    //中序遍历，递归方法
    public void inOrderTraversalWithRecursion(Node<V> node) {
        if (node != null) {
            inOrderTraversalWithRecursion(node.left);
            System.out.println(node.value);
            inOrderTraversalWithRecursion(node.right);
        }
    }

    //中序遍历，不使用递归的方法
    public void inOrderTraversal(Node<V> node) {
        Stack<Node<V>> treeStack = new Stack<>();
        while (node != null || !treeStack.isEmpty()) {
            while (node != null) {
                //中序遍历，不输出根节点
                treeStack.push(node);
                node = node.left;
            }

            if (!treeStack.isEmpty()) {
                node = treeStack.pop();
                System.out.println(node.getValue());
                node = node.right;
            }
        }

    }

    //后序遍历，递归方法
    public void postOrderTraversalWithRecursion(Node<V> node) {
        if (node != null) {
            postOrderTraversalWithRecursion(node.left);
            postOrderTraversalWithRecursion(node.right);
            System.out.println(node.value);
        }
    }

    //后序遍历，不使用递归的方法
    public void postOrderTraversal(Node<V> node) {
        Stack<Node<V>> treeStack = new Stack<>();
        Node<V> lastVisit = node;
        while (node != null || !treeStack.isEmpty()) {
            while (node != null) {
                treeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeStack.peek();
            //如果其右子树为空或者右子树已经访问，直接输出当前节点，否则继续遍历右子树
            if (node.right == null || node.right == lastVisit) {
                System.out.println(node.getValue());
                treeStack.pop();
                //设置上次访问的节点
                lastVisit = node;
                //设置为null,表示没有数据可以访问，需要从栈中弹出，所以设置为null
                node = null;
            } else {
                node = node.right;
            }
        }

    }

    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>();
        myTree.insertNode(new Node<>(5));
        myTree.insertNode(new Node<>(2));
        myTree.insertNode(new Node<>(1));
        myTree.insertNode(new Node<>(3));
        Node<Integer> node = new Node<>(4);
        myTree.insertNode(node);
        myTree.insertNode(new Node<>(6));
        myTree.preorderTraversal(myTree.root);
        myTree.deleteNode(node);
    }

    static class Node<V> {
        private Node<V> parent;

        private Node<V> left;

        private Node<V> right;

        private Integer i;

        private V value;

        public Node(V v) {
            this.value = v;
            if (v instanceof Integer) {
                i = (Integer) value;
            }
        }

        public V getValue() {
            return value;
        }
    }
}
