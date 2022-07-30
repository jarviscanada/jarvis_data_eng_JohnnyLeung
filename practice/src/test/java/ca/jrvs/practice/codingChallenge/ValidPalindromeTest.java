package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidPalindromeTest {

    private ValidPalindrome validPalindrome;

    @Before
    public void setUp() {
        validPalindrome = new ValidPalindrome();
    }

    @Test
    public void twoPointers() {
        Assert.assertTrue(validPalindrome.twoPointers(" "));
        Assert.assertTrue(validPalindrome.twoPointers("a,!"));
        Assert.assertTrue(validPalindrome.twoPointers("Aa"));
        Assert.assertTrue(validPalindrome.twoPointers("aBA//"));
        Assert.assertTrue(validPalindrome.twoPointers("aw 1wa"));
        Assert.assertTrue(validPalindrome.twoPointers("race car"));
        Assert.assertTrue(validPalindrome.twoPointers("A man, a plan, a canal: Panama"));

        Assert.assertFalse(validPalindrome.twoPointers("My name is Eminem!"));
        Assert.assertFalse(validPalindrome.twoPointers("race 1 car"));
        Assert.assertFalse(validPalindrome.twoPointers("abb"));
    }

    @Test
    public void recursion() {
        Assert.assertTrue(validPalindrome.recursion(" "));
        Assert.assertTrue(validPalindrome.recursion("a,!"));
        Assert.assertTrue(validPalindrome.recursion("Aa"));
        Assert.assertTrue(validPalindrome.recursion("aBA//"));
        Assert.assertTrue(validPalindrome.recursion("aw 1wa"));
        Assert.assertTrue(validPalindrome.recursion("race car"));
        Assert.assertTrue(validPalindrome.recursion("A man, a plan, a canal: Panama"));

        Assert.assertFalse(validPalindrome.recursion("My name is Eminem!"));
        Assert.assertFalse(validPalindrome.recursion("race 1 car"));
        Assert.assertFalse(validPalindrome.recursion("abb"));
    }

}