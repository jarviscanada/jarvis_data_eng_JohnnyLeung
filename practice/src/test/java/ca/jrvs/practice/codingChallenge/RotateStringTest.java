package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class RotateStringTest {

    private final RotateString rotateString = new RotateString();

    @Test
    public void simpleCheck() {
        Assert.assertTrue(rotateString.simpleCheck("abcde", "deabc"));
        Assert.assertFalse(rotateString.simpleCheck("abcde", "acbde"));
        Assert.assertFalse(rotateString.simpleCheck("abs", "a"));
        Assert.assertFalse(rotateString.simpleCheck("a", "b"));
        Assert.assertTrue(rotateString.simpleCheck("a", "a"));
        Assert.assertFalse(rotateString.simpleCheck(null, null));
    }

}