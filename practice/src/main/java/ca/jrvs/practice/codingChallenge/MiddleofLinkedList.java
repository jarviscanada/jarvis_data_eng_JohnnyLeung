package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Middle-of-the-Linked-List-b2a8e0c865f84ced816fea3d3db5fac1 */
public class MiddleofLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* O(n). Only pass through all nodes once. */
    public ListNode middleNode(ListNode head) {
        int middleIndex = 0;
        int numNodes = 0;
        ListNode current = head;
        ListNode middle = head;

        while(current != null) {
            numNodes++;
            if ((int)(numNodes / 2) > middleIndex) {
                middleIndex++;
                middle = middle.next;
            }
            current = current.next;
        }

        return middle;
    }

}
