package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Duplicates-from-Sorted-Array-39c30eab664c469ca82a22c5b059165f */
public class DuplicatesfromSortedArray {

    /*: O(n). Pass through nums once. */
    public int twoPointers(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;

        int previous = nums[0];
        int i = 1, j = 1;

        for (i = 1; i < nums.length; i++) {
            if (nums[i] != previous) {
                nums[j] = nums[i];
                j++;
            }
            previous = nums[i];
        }
        return j;
    }

}
