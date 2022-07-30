package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementStackUsingQueuesTest {

    private ImplementStackUsingQueues isuq;

    @Before
    public void setUp() {
        isuq = new ImplementStackUsingQueues();
        isuq.push(5);
        isuq.push(6);
    }

    @Test
    public void push() {
        assertFalse(isuq.empty());
    }

    @Test
    public void pop() {
        Assert.assertEquals(6, isuq.pop());
        Assert.assertEquals(5, isuq.pop());
    }

    @Test
    public void top() {
        Assert.assertEquals(6, isuq.top());
        Assert.assertEquals(6, isuq.top());
    }

    @Test
    public void empty() {
        Assert.assertFalse(isuq.empty());
        isuq.pop(); isuq.pop();
        Assert.assertTrue(isuq.empty());
    }

}