package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* https://www.notion.so/jarvisdev/Valid-Anagram-71f40c5b0e954f5a87e88b9c4ea1b111 */
public class ValidAnagram {

    /* O(nlogn). Sorting. */
    public boolean sorting(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            throw new IllegalArgumentException("Strings must have length of at least 1");

        if (s.length() != t.length())
            return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(tArr);
        Arrays.sort(sArr);

        return Arrays.equals(Arrays.copyOfRange(sArr, 0, tArr.length), tArr);
    }

    /* O(n) Go through all n characters once to populate hashmap, then once more to validate. */
    public boolean hashMap(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            throw new IllegalArgumentException("Strings must have length of at least 1");

        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        char curr;

        for(int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if (map.containsKey(curr))
                map.put(curr, map.get(curr) + 1);
            else
                map.put(curr, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            curr = t.charAt(i);
            if (!map.containsKey(curr) || map.get(curr) == 0)
                return false;
            map.put(curr, map.get(curr) - 1);
        }

        return true;
    }

}
