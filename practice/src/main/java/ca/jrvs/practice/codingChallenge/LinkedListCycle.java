package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/* https://www.notion.so/jarvisdev/LinkedList-Cycle-636b9a8b856040aea8d112263a52208a */
public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /* O(n). Need to check each node to uncover a cycle. */
    public boolean hasCycleSetApproach(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            if (set.contains(current))
                return true;
            set.add(current);
            current = current.next;
        }
        return false;
    }

    /* O(n) */
    public boolean hasCycleTwoPointers(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head; ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }
        return false;
    }

}
