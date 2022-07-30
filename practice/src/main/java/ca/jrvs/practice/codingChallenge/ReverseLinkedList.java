package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Reverse-Linked-List-2a6be6d942c7467397fe91f621d135b2 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* O(n). Pass through all nodes once. */
    public ListNode iteration(ListNode head) {
        ListNode current = head, previous = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /* O(n) */
    public ListNode recursion(ListNode head) {
        ListNode tail;
        if (head == null || head.next == null)
            return head;
        else
            tail = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

}
