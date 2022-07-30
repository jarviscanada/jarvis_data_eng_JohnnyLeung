package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

/* https://www.notion.so/jarvisdev/Implement-Queue-using-Stacks-7de7b3723a1841d3b414dc4c23e0312f */
public class ImplementQueueUsingStacks {

    private final Stack<Integer> empty, full;

    /* O(1) */
    public ImplementQueueUsingStacks() {
        empty = new Stack<>();
        full = new Stack<>();
    }

    /* O(n). Need to iterate through all existing elements twice. */
    public void push(int x) {
        while (!full.empty())
            empty.push(full.pop());

        full.push(x);

        while (!empty.empty())
            full.push(empty.pop());
    }

    /* O(1) */
    public int pop() {
        return full.pop();
    }

    /* O(1) */
    public int peek() {
        return full.peek();
    }

    /* O(1) */
    public boolean empty() {
        return full.empty();
    }
}

class ImplementQueueUsingStacksUnitTime {

    private final Stack<Integer> popStack, pushStack;

    /* O(1) */
    public ImplementQueueUsingStacksUnitTime() {
        popStack = new Stack<>();
        pushStack = new Stack<>();
    }

    /* O(1) */
    public void push(int x) {
        pushStack.push(x);
    }


    /* O(1). When popStack is empty, filling it is O(n). However, it then
     * lasts for n pops without needing to be refilled. O(n/n) = O(1). */
    public int pop() {
        if (popStack.empty())
            while (!pushStack.empty())
                popStack.push(pushStack.pop());
        return popStack.pop();
    }

    /* O(1) */
    public int peek() {
        int result = pop();
        popStack.push(result);
        return result;
    }

    /* O(1) */
    public boolean empty() {
        return popStack.empty() && pushStack.empty();
    }

}
