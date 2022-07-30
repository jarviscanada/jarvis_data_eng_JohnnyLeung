package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class PrintLetterWithNumberTest {

    private final PrintLetterWithNumber solver = new PrintLetterWithNumber();

    @Test
    public void enumerateStringChars() {
        Assert.assertEquals("", solver.enumerateStringChars(""));
        Assert.assertEquals("a1", solver.enumerateStringChars("a"));
        Assert.assertEquals("a1b2c3d4", solver.enumerateStringChars("abcd"));
        Assert.assertEquals("J36o15h8n14", solver.enumerateStringChars("John"));
        Assert.assertEquals("H34e5l12l12o15W49o15r18l12d4", solver.enumerateStringChars("HelloWorld"));
        Assert.assertEquals("", solver.enumerateStringChars("jhgjgh%%"));
    }

}