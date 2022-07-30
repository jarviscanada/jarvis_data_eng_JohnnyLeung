package ca.jrvs.practice.codingChallenge;

import java.util.EmptyStackException;
import java.util.Stack;

/* https://www.notion.so/jarvisdev/Valid-Parentheses-d3bd6c213fda4efb89a4b45ebd543c07 */
public class ValidParentheses {

    private final Stack<Character> stack = new Stack<>();

    /* O(n). Iterate through each character once, and perform unit-time operations. */
    public boolean isValid(String s) {
        char current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '(')
                stack.push(')');
            else if (current == '[')
                stack.push(']');
            else if (current == '{')
                stack.push('}');
            else if (current != tryPop())
                return false;
        }
        return stack.empty();
    }

    private char tryPop() {
        try {
            return stack.pop();
        } catch (EmptyStackException ex) {
            return '\0';
        }
    }

}
