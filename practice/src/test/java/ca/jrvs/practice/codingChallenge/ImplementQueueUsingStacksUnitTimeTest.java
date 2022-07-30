package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImplementQueueUsingStacksUnitTimeTest {

    private ImplementQueueUsingStacksUnitTime iqusut;

    @Before
    public void setUp() {
        iqusut = new ImplementQueueUsingStacksUnitTime();
        iqusut.push(5);
        iqusut.push(6);
        iqusut.push(7);
    }

    @Test
    public void push() {
        Assert.assertFalse(iqusut.empty());
    }

    @Test
    public void pop() {
        Assert.assertEquals(5, iqusut.pop());
        Assert.assertEquals(6, iqusut.pop());
        Assert.assertEquals(7, iqusut.pop());
        Assert.assertTrue(iqusut.empty());
    }

    @Test
    public void peek() {
        Assert.assertEquals(5, iqusut.peek());
        Assert.assertEquals(5, iqusut.peek());
        Assert.assertEquals(5, iqusut.pop());
        Assert.assertEquals(6, iqusut.peek());
    }

    @Test
    public void empty() {
        Assert.assertFalse(iqusut.empty());
        iqusut.pop();
        iqusut.pop();
        iqusut.pop();
        Assert.assertTrue(iqusut.empty());
    }

}