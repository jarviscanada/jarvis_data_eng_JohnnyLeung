package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrayTest {

    private final MergeSortedArray solver = new MergeSortedArray();

    @Test
    public void merge() {
        int[] nums1 = {1, 2, 3, 4, 0, 0, 0};
        int[] nums2 = {-2, 3, 99};
        int[] correct = {-2, 1, 2, 3, 3, 4, 99};
        solver.merge(nums1, 4, nums2, 3);
        Assert.assertArrayEquals(correct, nums1);
    }

}