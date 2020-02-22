package easy;

import java.util.HashMap;
import java.util.Map;

/* #1
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        int[] result = new TwoSum().twoSum(nums, target);
        if (result.length != 0) {
            System.out.println("return: " + result[0] + ", " + result[1]);
            int first = nums[result[0]];
            int second = nums[result[1]];
            System.out.println(first + "+" + second + "=" + target);
            assert first + second == target : "Solution is wrong";
        }
        System.out.println("No solution");
    }

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> indexByNumber = new HashMap<>();
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            Integer second = indexByNumber.get(target - nums[first]);
            if (second != null) {
                return new int[]{first, second};
            }
            indexByNumber.put(nums[first], first);
        }
        return new int[]{};
    }
}
