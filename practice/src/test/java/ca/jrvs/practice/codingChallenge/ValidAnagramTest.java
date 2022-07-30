package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class ValidAnagramTest {

    private static final ValidAnagram validAnagram = new ValidAnagram();

    @Test
    public void sorting() {
        Assert.assertFalse(validAnagram.sorting("a", "b"));
        Assert.assertTrue(validAnagram.sorting("a","a"));
        Assert.assertTrue(validAnagram.sorting("tomato", "amoott"));
        Assert.assertFalse(validAnagram.sorting("abc", "abcd"));
    }

    @Test
    public void hashMap() {
        Assert.assertFalse(validAnagram.hashMap("a", "b"));
        Assert.assertTrue(validAnagram.hashMap("a","a"));
        Assert.assertTrue(validAnagram.hashMap("tomato", "amoott"));
        Assert.assertFalse(validAnagram.hashMap("abc", "abcd"));
    }

}