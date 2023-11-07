package org.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum_1(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if(numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }

        return null;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum_3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left != right) {
            if (nums[left] + nums[right] < target) {
                left+=1;
            } else if (nums[left] + nums[right] > target) {
                right-=1;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 8;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum_1(nums, target)));
        System.out.println(Arrays.toString(twoSum_2(nums, target)));
        System.out.println(Arrays.toString(twoSum_3(nums, target)));
    }

}
