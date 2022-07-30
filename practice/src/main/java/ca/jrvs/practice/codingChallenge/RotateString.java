package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Rotate-String-ae91f1db89e54fc0919ee18d5b7f9960 */
public class RotateString {

    /* O(n). String.contains() is O(n) (need to iterate through the string once). */
    public boolean simpleCheck(String s, String goal) {
        if (s == null || goal == null)
            return false;
        if (s.length() != goal.length())
            return false;
        return (s + s).contains(goal);
    }

}
