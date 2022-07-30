package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* https://www.notion.so/jarvisdev/Duplicate-Characters-9a56af8edbfc4f28abf9cb7239da6c88 */
public class DuplicateCharacters {

    /* O(n) Iterate through String s's characters once. */
    public char[] findDuplicateChars(String s) {
        char[] duplicates = new char[s.length()/2];
        int j = 0;
        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c)) {
                    map.put(c, true);
                    duplicates[j] = c;
                    j++;
                }
            }
            else {
                map.put(c, false);
            }
        }
        return Arrays.copyOfRange(duplicates, 0, j);
    }

}
