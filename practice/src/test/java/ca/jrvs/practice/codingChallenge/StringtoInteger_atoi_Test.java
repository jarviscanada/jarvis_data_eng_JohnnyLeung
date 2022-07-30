package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class StringtoInteger_atoi_Test {

    private StringtoInteger_atoi_ sti = new StringtoInteger_atoi_();

    @Test
    public void builtInParsingAtoi() {
        Assert.assertEquals(590034, sti.builtInParsingMethod("590034"));
        Assert.assertEquals(-590034, sti.builtInParsingMethod("-590034"));
        Assert.assertEquals(590034, sti.builtInParsingMethod("59dd0034"));
        Assert.assertEquals(-590034, sti.builtInParsingMethod("-59dd0034"));
    }

    @Test
    public void myAtoi() {
        Assert.assertEquals(590034, sti.myAtoi("590034"));
        Assert.assertEquals(-590034, sti.myAtoi("-590034"));
        Assert.assertEquals(590034, sti.myAtoi("59dd0034"));
        Assert.assertEquals(-590034, sti.myAtoi("-59dd0034"));
    }

}