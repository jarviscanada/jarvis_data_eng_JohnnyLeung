package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://www.notion.so/jarvisdev/Contains-Duplicate-1aca53b698a142be8f24df49017079f2 */
public class ContainsDuplicate {

    /* O(nlogn). Need to run quick sort. */
    public boolean sorting(int[] nums) {
        Arrays.sort(nums);
        for (int previous = 0, i = 1; i < nums.length; i++, previous++) {
            if (nums[previous] == nums[i])
                return true;
        }
        return false;
    }

    /* O(n). Pass through the array once. */
    public boolean set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (set.contains(num))
                return true;
            else
                set.add(num);
        return false;
    }

}
