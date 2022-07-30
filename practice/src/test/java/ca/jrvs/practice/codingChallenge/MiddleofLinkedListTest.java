package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.MiddleofLinkedList.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class MiddleofLinkedListTest {

    private MiddleofLinkedList solver = new MiddleofLinkedList();

    @Test
    public void middleNode() {
        ListNode head = null;
        Assert.assertNull(solver.middleNode(head));
        head = new ListNode(1);
        Assert.assertEquals(head, solver.middleNode(head));
        head.next = new ListNode(2);
        Assert.assertEquals(head.next, solver.middleNode(head));

        ListNode current = head.next;
        ListNode middle = null;
        for (int i = 3; i < 51; i++) {
            current.next = new ListNode(i);
            current = current.next;
            if (i == 26)
                middle = current;
        }

        Assert.assertEquals(middle, solver.middleNode(head));
    }

}