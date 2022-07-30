package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class DuplicateLinkedListNodeTest {

    final DuplicateLinkedListNode remover = new DuplicateLinkedListNode();

    @Test
    public void removeDuplicates() {
        LinkedList<Integer> list = new LinkedList<>();
        remover.removeDuplicates(list);
        list.add(1); list.add(1); list.add(1);
        remover.removeDuplicates(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(1, list.get(0), 0);
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
        remover.removeDuplicates(list);
        Assert.assertEquals(6, list.size());
        list.add(1);list.add(2);list.add(2);list.add(4);list.add(5);list.add(4);
        list.add(19);list.add(2);list.add(31);list.add(14);list.add(5);list.add(6);
        remover.removeDuplicates(list);
        Assert.assertEquals(9, list.size());
        Assert.assertEquals(1, list.get(0), 0);
        Assert.assertEquals(14, list.get(8), 0);
    }

}