package ca.jrvs.practice.codingChallenge;

import java.util.Map;

/* https://www.notion.so/jarvisdev/How-to-compare-two-maps-5cc3b947c808459daa64b8d978dac874 */
public class CompareTwoMaps {

    /* Complexity: O(n). The equals method iterates through one map of n values,
     * and uses get and containsKey to compare the maps, both of which are O(1)
     */
    public <K, V> boolean compareMaps(Map<K, V> m1, Map<K, V> m2) {
        return m1.equals(m2);
    }

}