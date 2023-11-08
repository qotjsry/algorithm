package org.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax <= rightMax) {
                volume += leftMax - height[left];
                left += 1;
            } else {
                volume += rightMax - height[right];
                right -= 1;
            }
        }
        return volume;
    }

    public static int trap_1(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();

                if(stack.isEmpty())
                    break;

                int distance = i - stack.peek() - 1;
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                volume += distance * waters;
            }

            stack.push(i);
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] heights = {1,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("trap(heights) = " + trap(heights));
        System.out.println("trap(heights) = " + trap_1(heights));
    }

}
