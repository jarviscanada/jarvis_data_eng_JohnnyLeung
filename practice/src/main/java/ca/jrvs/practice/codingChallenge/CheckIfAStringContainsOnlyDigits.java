package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Check-if-a-String-contains-only-digits-d5b088e299ba489bac92dbc47c920b37 */
public class CheckIfAStringContainsOnlyDigits {

    public boolean checkStringASCII(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.codePointAt(i) < 48 || s.codePointAt(i) > 57)
                return false;
        return true;
    }

    /* O(n). Need to verify all n characters. */
    public boolean checkStringJavaInteger(String s) {
        boolean isInteger = true;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            isInteger = false;
        }
        return isInteger;
    }

    /* O(n) */
    public boolean checkStringRegex(String s) {
        return s.matches("[0-9]+");
    }

}
