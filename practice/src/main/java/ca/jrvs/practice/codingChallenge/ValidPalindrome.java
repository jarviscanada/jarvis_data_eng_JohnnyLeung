package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Valid-Palindrome-738e2b75412440b48f290747b7060e55 */
public class ValidPalindrome {

    private String str;

    /* O(n). Need to iterate through each character and sanitize it as well as compare. */
    public boolean twoPointers(String s) {
        s = sanitizeString(s);
        if (s.isEmpty())
            return true;

        int front = -1, back = s.length();

        while (front++ < back--) {
            if (s.charAt(front) != s.charAt(back)) {
                return false;
            }
        }
        return true;
    }

    private String sanitizeString(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        return s;
    }

    /* O(n). need to iterate through each character and sanitize it as well as compare. */
    public boolean recursion(String s) {
        str = sanitizeString(s);
        return recursiveSolution(0, str.length()-1);
    }

    private boolean recursiveSolution(int front, int back) {
        if (front >= back)
            return true;

        if (str.charAt(front) != str.charAt(back))
            return false;

        return recursiveSolution(front+1, back-1);
    }

}
