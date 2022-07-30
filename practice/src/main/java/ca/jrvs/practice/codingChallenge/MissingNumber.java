package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/* https://www.notion.so/jarvisdev/Missing-Number-285054c3280a475d9d7dce00739d17ee */
public class MissingNumber {

    /* O(n). Only need to go through nums once. */
    public int FindBySumming(int[] nums) {
        int expectedSum = nums.length;
        int actualSum = 0;

        for (int i = 0; i < nums.length; i++) {
            expectedSum += i;
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }

    /* O(n) */
    public int FindUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        for (int i = 0; i <= nums.length; i++)
            if (!set.contains(i))
                return i;

        return nums.length + 1;
    }

    /* O(n) */
    public int FindWithGaussFormula(int[] nums) {
        int expectedSum = (nums.length * nums.length + nums.length) / 2;
        int actualSum = 0;

        for (int num : nums)
            actualSum += num;

        return expectedSum - actualSum;
    }

}
