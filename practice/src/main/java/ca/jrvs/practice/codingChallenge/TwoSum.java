package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Map;

/* https://www.notion.so/jarvisdev/Two-Sum-243f35228d6447389aa6cdf762f01e94 */
public class TwoSum {

    /* O(n^2). Two nested for-loops each iterating over n elements. */
    public int[] bruteForce(int[] nums, int target) {
        int[] sol = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sol[0] = nums[i];
                    sol[1] = nums[j];
                    return sol;
                }
            }
        }
        return sol;
    }

    /* Loop through n array once. */
    public int[] linear(int[] nums, int target) {
        int[] sol = {-1,-1};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(target - nums[i])){
                map.put(nums[i], i);
            }
            else {
                sol[0] = target - nums[i];
                sol[1] = nums[i];
                return sol;
            }
        }
        return sol;
    }

}
