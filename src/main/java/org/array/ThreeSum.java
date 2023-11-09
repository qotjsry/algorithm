package org.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0)
                        results.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return results;
    }

    public static List<List<Integer>> threeSum_1(int[] nums) {
        int left, right, sum;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length -2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum < 0)
                    left += 1;
                else if (sum > 0)
                    right -= 1;
                else
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                while (left < right && nums[left] == nums[left + 1])
                    left += 1;
                while (left < right && nums[right] == nums[right - 1])
                    right -= 1;

                left += 1;
                right -= 1;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -5};

        System.out.println("threeSum(nums) = " + threeSum(nums));
        System.out.println("threeSum(nums) = " + threeSum_1(nums));
    }

}
