package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.ReverseLinkedList.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseLinkedListTest {

    ListNode head;
    ReverseLinkedList rll;
    ListNode fifth;

    @Before
    public void setUp() throws Exception {
        rll = new ReverseLinkedList();
        head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
    }

    @Test
    public void iteration() {
        ListNode actual = rll.iteration(head);
        Assert.assertEquals(5, actual.val);
        actual = actual.next;
        Assert.assertEquals(4, actual.val);
        actual = actual.next;
        Assert.assertEquals(3, actual.val);
        actual = actual.next;
        Assert.assertEquals(2, actual.val);
        actual = actual.next;
        Assert.assertEquals(1, actual.val);
    }

    @Test
    public void recursion() {
        ListNode actual = rll.recursion(head);
        Assert.assertEquals(5, actual.val);
        actual = actual.next;
        Assert.assertEquals(4, actual.val);
        actual = actual.next;
        Assert.assertEquals(3, actual.val);
        actual = actual.next;
        Assert.assertEquals(2, actual.val);
        actual = actual.next;
        Assert.assertEquals(1, actual.val);
    }

}