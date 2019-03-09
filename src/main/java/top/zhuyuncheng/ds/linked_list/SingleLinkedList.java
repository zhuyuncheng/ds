package top.zhuyuncheng.ds.linked_list;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList<T> {
    private int size;
    private Node head;

    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public SingleLinkedList() {
        this.size = 0;
        head = null;
    }

    public T addLast(T obj) {
        if (size == 0) {
            return addHead(obj);
        }
        Node curr = head;
        for (; curr.next != null; curr = curr.next) continue;
        curr.next = new Node(obj);
        size++;
        return obj;
    }

    /*
     *  在链表头部添加元素
     */
    public T addHead(T obj) {
        Node newHaed = new Node(obj);
        if (size == 0) {
            head = newHaed;
        } else {
            newHaed.next = head;
            head = newHaed;
        }
        size++;
        return obj;
    }

    /*
     *  获取指定位置元素
     */
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        Node curr = head;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        return curr.data;
    }

    /*
     *  获取头部元素
     */
    public T get() {
        if (size == 0) {
            return null;
        }

        return head.data;
    }

    /*
     *  删除链表头部元素
     */
    public T removeHead() {
        T obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    /*
     *  删除指定元素
     */
    public boolean remove(T obj) {
        if (size == 0) {
            return false;
        }

        Node p = head;
        for (Node curr = head.next; curr != null; curr = curr.next) {
            if (obj.equals(curr.data)) {
                p.next = curr.next;
                size--;
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            list.add(String.valueOf(curr.data));
            curr = curr.next;
        }
        return StringUtils.join(list, ", ");
    }

}
