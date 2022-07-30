package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

    private int[][] nums;
    private int[][] sols;
    private int[] targets;
    private TwoSum twoSum;

    @Before
    public void setUp() {
        nums = new int[][] {{2, 7, 11, 15},
                {3, 2, 4},
                {3, 3},
                {15, 2, 3, 5, 7, 8, 9, 10},
                {19, 5, 3, 6, 7, 0, 14, 20}};

        targets = new int[]{9, 6, 6, 20, 13};

        sols = new int[][] {{2, 7},
                {2, 4},
                {3, 3},
                {15, 5},
                {6, 7}};

        twoSum = new TwoSum();
    }

    @Test
    public void testBruteForce() {
        int[] computed;
        for (int i = 0; i < nums.length; i++) {
            computed = twoSum.bruteForce(nums[i], targets[i]);
            Assert.assertArrayEquals(computed, sols[i]);
        }
    }

    @Test
    public void testLinear() {
        int[] computed;
        for (int i = 0; i < nums.length; i++) {
            computed = twoSum.linear(nums[i], targets[i]);
            Assert.assertArrayEquals(computed, sols[i]);
        }
    }

}