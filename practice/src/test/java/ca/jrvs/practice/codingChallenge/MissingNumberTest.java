package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class MissingNumberTest {

    private static final MissingNumber solver = new MissingNumber();
    private static final int[] arr1 = {0, 1, 3};
    private static final int[] arr2 = {0, 1};
    private static final int[] arr3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    private static final int[] arr4 = {0};

    @Test
    public void findBySumming() {
        Assert.assertEquals(2, solver.FindBySumming(arr1));
        Assert.assertEquals(2, solver.FindBySumming(arr2));
        Assert.assertEquals(8, solver.FindBySumming(arr3));
        Assert.assertEquals(1, solver.FindBySumming(arr4));
    }

    @Test
    public void findUsingSet() {
        Assert.assertEquals(2, solver.FindUsingSet(arr1));
        Assert.assertEquals(2, solver.FindUsingSet(arr2));
        Assert.assertEquals(8, solver.FindUsingSet(arr3));
        Assert.assertEquals(1, solver.FindUsingSet(arr4));
    }

    @Test
    public void findWithGaussFormula() {
        Assert.assertEquals(2, solver.FindWithGaussFormula(arr1));
        Assert.assertEquals(2, solver.FindWithGaussFormula(arr2));
        Assert.assertEquals(8, solver.FindWithGaussFormula(arr3));
        Assert.assertEquals(1, solver.FindWithGaussFormula(arr4));
    }

}