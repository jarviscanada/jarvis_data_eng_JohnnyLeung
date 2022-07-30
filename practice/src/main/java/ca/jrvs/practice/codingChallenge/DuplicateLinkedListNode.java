package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* https://www.notion.so/jarvisdev/Duplicate-LinkedList-Node-579c8c360ccb4a87a4c4eee35d806aff */
public class DuplicateLinkedListNode {

    /* O(n). Only traverse all linked list nodes once. */
    public void removeDuplicates(LinkedList<Integer> list) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < list.size()) {
            if (set.contains(list.get(i)))
                list.remove(i);
            else {
                set.add(list.get(i));
                i++;
            }
        }
    }

}
