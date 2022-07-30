package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.NthNodefromEndofLinkedList.ListNode;
import org.junit.Assert;
import org.junit.Test;
public class NthNodefromEndofLinkedListTest {

    private final NthNodefromEndofLinkedList remover = new NthNodefromEndofLinkedList();

    @Test
    public void removeNthFromEnd() {
        ListNode head = new ListNode(0);
        try {
            remover.removeNthFromEnd(head, 0);
            remover.removeNthFromEnd(head, 1);
            remover.removeNthFromEnd(head, 5);
        } catch (Exception e) {
            Assert.fail();
        }

        ListNode temp = head;
        for (int i = 1; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        head = remover.removeNthFromEnd(head, 10);
        Assert.assertEquals(1, head.val);
        head = remover.removeNthFromEnd(head, 7);
        Assert.assertEquals(2, head.next.val);
        Assert.assertEquals(4, head.next.next.val);
    }

}