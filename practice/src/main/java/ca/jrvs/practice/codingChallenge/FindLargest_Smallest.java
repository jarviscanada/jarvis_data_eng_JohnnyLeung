package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* https://www.notion.so/jarvisdev/Find-Largest-Smallest-4e9f30ce482e4567a058cdf730165bba */
public class FindLargest_Smallest {

    public int forLoop(int[] arr, boolean largest) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Array cannot be empty");
        int maxmin = arr[0];
        for (int num : arr)
            if (largest && maxmin < num)
                maxmin = num;
            else if (!largest && maxmin > num)
                maxmin = num;
        return maxmin;
    }

    public int streamAPI(int[] arr, boolean largest) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Array cannot be empty");
        if (largest)
            return Arrays.stream(arr).max().getAsInt();
        else
            return Arrays.stream(arr).min().getAsInt();
    }

    public Integer javaAPI(List<Integer> arr, boolean largest) {
        if (arr.size() == 0)
            throw new IllegalArgumentException("Array cannot be empty");
        if (largest)
            return Collections.max(arr);
        else
            return Collections.min(arr);
    }

}
