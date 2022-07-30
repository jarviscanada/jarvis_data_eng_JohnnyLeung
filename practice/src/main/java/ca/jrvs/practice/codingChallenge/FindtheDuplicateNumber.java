package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://www.notion.so/jarvisdev/Find-the-Duplicate-Number-6e3025acb54440ebbc81dc4cd3a7ee08 */
public class FindtheDuplicateNumber {

    /* O(nlogn). Sorting uses O(nlogn) time. */
    public int sorting(int[] nums) {
        Arrays.sort(nums);

        int previous = 0;
        for (int num : nums)
            if (num == previous)
                return num;
            else
                previous = num;
        return -1;
    }

    /* O(n). Pass through the array only once. */
    public int set(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            if (set.contains(num))
                return num;
            else
                set.add(num);
        return -1;
    }

    public int properSolution(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[nums[0]]];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

}
