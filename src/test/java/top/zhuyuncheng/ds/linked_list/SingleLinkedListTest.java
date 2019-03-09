package top.zhuyuncheng.ds.linked_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class SingleLinkedListTest {

    private SingleLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new SingleLinkedList<>();
    }

    @Test
    public void get() {
        Integer element = list.get();
        Assert.assertNull(element);
        list.addLast(1);
        element = list.get();
        Assert.assertTrue(1 == element);
        list.addLast(2);
        list.addLast(3);
        Assert.assertTrue(list.get(1) == 2);
        Assert.assertNull(list.get(Integer.MAX_VALUE));
    }

    @Test
    public void addHead() {
        list.addHead(3);
        list.addHead(2);
        list.addHead(1);
        Assert.assertEquals(3, list.size());
        Assert.assertTrue(1 == Optional.ofNullable(list.get()).get());
    }

    @Test
    public void addLast() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Assert.assertEquals(3, list.size());
        Assert.assertTrue(1 == Optional.ofNullable(list.get()).get());
    }

    @Test
    public void removeHead() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Integer removeHead = list.removeHead();
        Assert.assertTrue(removeHead == 1);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void remove() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        boolean remove = list.remove(2);
        Assert.assertTrue(remove);
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(list.isEmpty());
    }
}
