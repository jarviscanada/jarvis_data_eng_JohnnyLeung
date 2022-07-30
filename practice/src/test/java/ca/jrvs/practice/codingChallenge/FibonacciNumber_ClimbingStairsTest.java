package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumber_ClimbingStairsTest {

    private FibonacciNumber_ClimbingStairs fn;
    private int[] fib;

    @Before
    public void setUp() {
        fn = new FibonacciNumber_ClimbingStairs();
    }

    @Test
    public void testFib() {
        fib = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        for (int i = 0; i < fib.length; i++) {
            Assert.assertEquals(fn.fib(i), fib[i]);
        }
    }

    @Test
    public void testFib2() {
        fib = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        for (int i = 0; i < fib.length; i++) {
            Assert.assertEquals(fn.fib2(i), fib[i]);
        }
    }

    @Test
    public void testFibNeg() {
        fib = new int[]{34, -21, 13, -8, 5, -3, 2, -1, 1, 0, 1};
        int j = 1;
        for (int i = fib.length - 1; i >= 0; i--) {
            Assert.assertEquals(fn.fib(j), fib[i]);
            j--;
        }
    }

    @Test
    public void testFib2Neg() {
        fib = new int[]{34, -21, 13, -8, 5, -3, 2, -1, 1, 0, 1};
        int j = 1;
        for (int i = fib.length - 1; i >= 0; i--) {
            Assert.assertEquals(fn.fib2(j), fib[i]);
            j--;
        }
    }

}