package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindLargest_SmallestTest {

    private static final FindLargest_Smallest solver = new FindLargest_Smallest();
    private static final int[] array = {14,22,999998,3746,20913,-99082,0,212};
    private static final List<Integer> list = new ArrayList<>();

    @BeforeClass
    public static void setUp() {
        for (int num : array)
            list.add(num);
    }

    @Test
    public void forLoop() {
        Assert.assertEquals(solver.forLoop(array, true), 999998);
        Assert.assertEquals(solver.forLoop(array, false), -99082);
    }

    @Test
    public void streamAPI() {
        Assert.assertEquals(solver.streamAPI(array, true), 999998);
        Assert.assertEquals(solver.streamAPI(array, false), -99082);
    }

    @Test
    public void javaAPI() {
        Assert.assertEquals(solver.javaAPI(list, true).intValue(), 999998);
        Assert.assertEquals(solver.javaAPI(list, false).intValue(), -99082);
    }

}