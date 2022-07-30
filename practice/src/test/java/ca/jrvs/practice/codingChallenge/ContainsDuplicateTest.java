package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicateTest {

    private ContainsDuplicate solver = new ContainsDuplicate();
    private int[] arr1 = {1,1};
    private int[] arr2 = {0};
    private int[] arr3 = {0,1,1,1,3,4,5,6,7,7};
    private int[] arr4 = {1,2,3,1};
    private int[] arr5 = {1,2,3,4};
    private int[] arr6 = {1,1,1,3,3,4,3,2,4,2};

    @Test
    public void sorting() {
        Assert.assertTrue(solver.sorting(arr1));
        Assert.assertFalse(solver.sorting(arr2));
        Assert.assertTrue(solver.sorting(arr3));
        Assert.assertTrue(solver.sorting(arr4));
        Assert.assertFalse(solver.sorting(arr5));
        Assert.assertTrue(solver.sorting(arr6));
    }

    @Test
    public void set() {
        Assert.assertTrue(solver.set(arr1));
        Assert.assertFalse(solver.set(arr2));
        Assert.assertTrue(solver.set(arr3));
        Assert.assertTrue(solver.set(arr4));
        Assert.assertFalse(solver.set(arr5));
        Assert.assertTrue(solver.set(arr6));
    }

}