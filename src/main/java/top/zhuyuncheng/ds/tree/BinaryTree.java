package top.zhuyuncheng.ds.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BinaryTree {

    /**
     * 前序遍历, 根-左-右
     */
    public void preorderTraversal(Node root) {
        System.out.print(root.val + " ");
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
    }

    /**
     * 前序遍历(非递归), 根-左-右
     */
    public void preorderTraversalNotRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }


    /**
     * 中序遍历，左-根-右
     */
    public void sequentialTraversal(Node root) {
        if (root.left != null) {
            sequentialTraversal(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            sequentialTraversal(root.right);
        }
    }

    /**
     * 中序遍历(非递归)，左-根-右
     */
    public void sequentialTraversalNotRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
           while (node != null) {
               stack.push(node);
               node = node.left;
           }

           if (!stack.isEmpty()) {
               node = stack.pop();
               System.out.print(node.val + " ");
               node = node.right;
           }
        }
    }


    /**
     * 后序遍历， 左-右-根
     */
    public void postOrderTraversal(Node root) {
        if (root.left != null) {
            postOrderTraversal(root.left);
        }
        if (root.right != null) {
            postOrderTraversal(root.right);
        }
        System.out.print(root.val + " ");
    }

    /**
     * 后序遍历(非递归)， 左-右-根
     */
    public void postOrderTraversalNotRecursion(Node root) {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node<String>> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            Node<String> node = s1.pop();
            s2.push(node);
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }

    /**
     * 层级遍历(非递归)，从上向下-从左向右
     */
    public void hierarchyTraversalNotRecursion(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
    }

    /*
     *        A
     *      /   \
     *     B     C
     *    / \   / \
     *   D   E F   G
     */
    public static void main(String[] args) {
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");

        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");

        Node<String> c = new Node<>(f, g, "C");
        Node<String> b = new Node<>(d, e, "B");
        Node<String> root = new Node<>(b, c, "A");

        BinaryTree main = new BinaryTree();

        System.out.print("前序遍历：");
        main.preorderTraversal(root);
        System.out.println();
        System.out.print("前序遍历(非递归)：");
        main.preorderTraversalNotRecursion(root);
        System.out.println();


        System.out.print("中序遍历：");
        main.sequentialTraversal(root);
        System.out.println();
        System.out.print("中序遍历(非递归)：");
        main.sequentialTraversalNotRecursion(root);
        System.out.println();

        System.out.print("后序遍历：");
        main.postOrderTraversal(root);
        System.out.println();
        System.out.print("后序遍历(非递归)：");
        main.postOrderTraversalNotRecursion(root);
        System.out.println();

        System.out.print("层级遍历(非递归)：");
        main.hierarchyTraversalNotRecursion(root);
        System.out.println();
    }

    private static class Node<T> {
        Node<String> left;
        Node<String> right;
        T val;

        Node(T val) {
            this.val = val;
        }

        Node(Node<String> left, Node<String> right, T val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
