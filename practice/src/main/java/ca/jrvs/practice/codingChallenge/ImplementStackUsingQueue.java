package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

/* https://www.notion.so/jarvisdev/Implement-Stack-using-Queue-2db9c4e390d34f3f8549bb9cead7dc18 */
public class ImplementStackUsingQueue {

    private final Queue<Integer> queue;

    /* O(1) */
    public ImplementStackUsingQueue() {
        queue = new LinkedList<>();
    }

    /* O(1) */
    public void push(int x) {
        queue.add(x);
    }

    /* O(n) Need to iterate through all n nodes to get the last one. */
    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++)
            queue.add(queue.remove());
        return queue.remove();
    }

    /* O(n) Need to iterate through all n nodes to get the last one. */
    public int top() {
        int top = pop();
        push(top);
        return top;
    }

    /* O(1) */
    public boolean empty() {
        return queue.isEmpty();
    }
}

class ImplementStackUsingQueues {

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;
    private boolean currentQ1 = true;

    /* O(1) */
    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /* O(1) */
    public void push(int x) {
        if (currentQ1)
            q1.add(x);
        else
            q2.add(x);
    }

    /* O(n) Need to iterate through all n nodes to get the last one. */
    public int pop() {
        int result;

        if (currentQ1) {
            while (q1.size() > 1)
                q2.add(q1.remove());
            result = q1.remove();
        }
        else {
            while (q2.size() > 1)
                q1.add(q2.remove());
            result = q2.remove();
        }
        currentQ1 = !currentQ1;
        return result;
    }

    /* O(n) Need to iterate through all n nodes to get the last one. */
    public int top() {
        int top = pop();
        push(top);
        return top;
    }

    /* O(1) */
    public boolean empty() {
        return currentQ1 ? q1.isEmpty() : q2.isEmpty();
    }

}
