package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class FindtheDuplicateNumberTest {

    private final FindtheDuplicateNumber solver = new FindtheDuplicateNumber();
    private final int[] arr1 = {1,3,4,2,2};
    private final int[] arr2 = {3,1,3,4,2};
    private final int[] arr3 = {1,1};
    private final int[] arr4 = {1,1,2};
    private final int[] arr5 = {1,6,2,2,2,3,4};

    @Test
    public void sorting() {
        Assert.assertEquals(2, solver.sorting(arr1));
        Assert.assertEquals(3, solver.sorting(arr2));
        Assert.assertEquals(1, solver.sorting(arr3));
        Assert.assertEquals(1, solver.sorting(arr4));
        Assert.assertEquals(2, solver.sorting(arr5));

    }

    @Test
    public void set() {
        Assert.assertEquals(2, solver.set(arr1));
        Assert.assertEquals(3, solver.set(arr2));
        Assert.assertEquals(1, solver.set(arr3));
        Assert.assertEquals(1, solver.set(arr4));
        Assert.assertEquals(2, solver.set(arr5));
    }

}