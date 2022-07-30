package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Test;

public class DuplicateCharactersTest {

    private final DuplicateCharacters solver = new DuplicateCharacters();

    @Test
    public void findDuplicateChars() {
        char[] arr = {'a', ' ', 'i', 'n', 'e', 'r', 'g'};
        Assert.assertArrayEquals(arr, solver.findDuplicateChars("Jarvis data engineering"));
    }

}