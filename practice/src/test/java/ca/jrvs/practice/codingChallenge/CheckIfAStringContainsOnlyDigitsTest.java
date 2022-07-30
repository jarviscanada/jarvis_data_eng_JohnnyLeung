package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class CheckIfAStringContainsOnlyDigitsTest {

    private CheckIfAStringContainsOnlyDigits solver = new CheckIfAStringContainsOnlyDigits();

    @Test
    public void checkStringASCII() {
        Assert.assertTrue(solver.checkStringASCII("1234567890"));
        Assert.assertTrue(solver.checkStringASCII("1"));
        Assert.assertFalse(solver.checkStringASCII("0.8"));
        Assert.assertFalse(solver.checkStringASCII("123,123,678"));
    }

    @Test
    public void checkStringJavaInteger() {
        Assert.assertTrue(solver.checkStringJavaInteger("1234567890"));
        Assert.assertTrue(solver.checkStringJavaInteger("1"));
        Assert.assertFalse(solver.checkStringJavaInteger("0.8"));
        Assert.assertFalse(solver.checkStringJavaInteger("123,123,678"));
    }

    @Test
    public void checkStringRegex() {
        Assert.assertTrue(solver.checkStringRegex("1234567890"));
        Assert.assertTrue(solver.checkStringRegex("1"));
        Assert.assertFalse(solver.checkStringRegex("0.8"));
        Assert.assertFalse(solver.checkStringRegex("123,123,678"));
    }

}