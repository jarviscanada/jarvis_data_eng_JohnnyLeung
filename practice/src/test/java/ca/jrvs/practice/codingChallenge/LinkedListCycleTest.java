package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.LinkedListCycle.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {

    private final LinkedListCycle solver = new LinkedListCycle();

    @Test
    public void hasCycleTwoPointers() {
        ListNode head = null;
        Assert.assertFalse(solver.hasCycleTwoPointers(head));
        head = new ListNode(0);
        Assert.assertFalse(solver.hasCycleTwoPointers(head));

        ListNode current = head;
        ListNode cycle = null;
        for (int i = 0; i < 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
            if (i == 5)
                cycle = current;
        }
        current.next = cycle;

        Assert.assertTrue(solver.hasCycleTwoPointers(head));
    }

}