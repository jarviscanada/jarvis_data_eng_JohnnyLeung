package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Swap-two-numbers-d18b7d0655634403b20679c58b40b96f */
public class SwapTwoNumbers {

    /* O(1) */
    public int[] swapByBits(int[] nums) {
        nums[0] ^= nums[1];
        nums[1] ^= nums[0];
        nums[0] ^= nums[1];

        return nums;
    }

    /* O(1) */
    public int[] swapByArithmetic(int[] nums) {
        nums[0] -= nums[1];
        nums[1] += nums[0];
        nums[0] = nums[1] - nums[0];

        return nums;
    }

}
