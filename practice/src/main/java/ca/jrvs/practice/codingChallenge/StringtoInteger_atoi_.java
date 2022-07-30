package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/String-to-Integer-atoi-39509d241bc44f76957215b968a5955b */
public class StringtoInteger_atoi_ {

    /* O(n). Iterate through all characters in s and append all numbers to sNums. */
    public int builtInParsingMethod(String s) {
        String sNums = "";
        int intS = 0;
        boolean neg = false;
        if (s.charAt(0) == '-') {
            neg = true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.codePointAt(i) >= 48 && s.codePointAt(i) <= 57) { // 0-9
                sNums = sNums + s.charAt(i);
            }
        }
        try {
            intS = Integer.parseInt(sNums);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        if (neg) {
            intS *= -1;
        }
        return intS;
    }

    /* O(n). Iterate through all characters in s and add to intS. */
    public int myAtoi(String s) {
        int intS = 0;
        boolean neg = false;
        int power = 0;
        if (s.charAt(0) == '-') {
            neg = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.codePointAt(i) >= 48 && s.codePointAt(i) <= 57) { // 0-9
                if (s.codePointAt(i) >= 49 && s.codePointAt(i) <= 57) { // add to intS if it's 1-9
                    intS += (s.codePointAt(i) - 48) * Math.pow(10, power);
                }
                power++;
            }
        }
        if (neg) {
            intS *= -1;
        }
        return intS;
    }

}
