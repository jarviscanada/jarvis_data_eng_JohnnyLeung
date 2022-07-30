package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class CountPrimesTest {

    private final CountPrimes solver = new CountPrimes();

    @Test
    public void sieveOfEratosthenes() {
        Assert.assertEquals(0, solver.sieveOfEratosthenes(0));
        Assert.assertEquals(0, solver.sieveOfEratosthenes(1));
        Assert.assertEquals(0, solver.sieveOfEratosthenes(2));
        Assert.assertEquals(1, solver.sieveOfEratosthenes(3));
        Assert.assertEquals(5, solver.sieveOfEratosthenes(13));
        Assert.assertEquals(25, solver.sieveOfEratosthenes(100));
    }

}