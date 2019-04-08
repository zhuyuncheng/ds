package top.zhuyuncheng.ds.linked_list;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SingleLinkedList<T> implements Iterable<T> {
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

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node curr = head;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T data = curr.data;
                curr = curr.next;
                return data;
            }
        };
    }

    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (Node curr = head; curr != null; curr = curr.next) {
            action.accept(curr.data);
        }
    }

    public Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return this.stream().map(String::valueOf).collect(Collectors.joining(" -> ", "[", "]"));
    }

}
