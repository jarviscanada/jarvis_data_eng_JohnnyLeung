package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Remove-Element-36ed8b62d5804bbd952bed0786f225d6 */
public class RemoveElement {

    /* O(n). Pass through the array once. */
    public int remove(int[] nums, int val) {
        int j = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val) {
                if (i != j)
                    nums[j] = nums[i];
                j++;
            }
        return j;
    }

}
