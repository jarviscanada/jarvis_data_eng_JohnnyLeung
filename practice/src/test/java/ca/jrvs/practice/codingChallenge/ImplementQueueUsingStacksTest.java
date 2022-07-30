package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImplementQueueUsingStacksTest {

    private ImplementQueueUsingStacks iqus;

    @Before
    public void setUp() {
        iqus = new ImplementQueueUsingStacks();
        iqus.push(5);
        iqus.push(6);
        iqus.push(7);
    }

    @Test
    public void push() {
        Assert.assertFalse(iqus.empty());
    }

    @Test
    public void pop() {
        Assert.assertEquals(5, iqus.pop());
        Assert.assertEquals(6, iqus.pop());
        Assert.assertEquals(7, iqus.pop());
        Assert.assertTrue(iqus.empty());
    }

    @Test
    public void peek() {
        Assert.assertEquals(5, iqus.peek());
        Assert.assertEquals(5, iqus.peek());
        Assert.assertEquals(5, iqus.pop());
        Assert.assertEquals(6, iqus.peek());
    }

    @Test
    public void empty() {
        Assert.assertFalse(iqus.empty());
        iqus.pop();
        iqus.pop();
        iqus.pop();
        Assert.assertTrue(iqus.empty());
    }

}