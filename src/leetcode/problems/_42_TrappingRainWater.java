package leetcode.problems;

import java.util.Stack;


/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.

    Example:

    Input: [0,1,0,2,1,0,1,3,2,1,2,1]

    Output: 6
*/

public class _42_TrappingRainWater {

    /*
        Time: O(N ^ 2)
        Memory: O(1)
    */

    public static int trap(int[] height) {
        int res = 0;
        int maxLeft, maxRight, i, j;
        for (int k = 1; k < height.length - 1; k++) {
            maxLeft = k - 1;
            maxRight = k + 1;

            for (i = maxLeft; i >= 0; i--) {
                if (height[maxLeft] < height[i]) {
                    maxLeft = i;
                }
            }


            for (j = maxRight; j < height.length; j++) {
                if (height[maxRight] < height[j]) {
                    maxRight = j;
                }
            }

            res += Math.max(0, Math.min(height[maxLeft], height[maxRight]) - height[k]);
        }
        return res;
    }


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int trapUsingDP(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];

        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.max(0, Math.min(maxRight[i], maxLeft[i]) - height[i]);
        }
        return res;
    }


    /*
       Time: O(N)
       Memory: O(N)
    */

    public static int trapUsingStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int current = 0;
        stack.add(0);
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int distance = current - stack.peek() - 1;
                int h = Math.min(height[stack.peek()], height[current]) - height[top];
                res += distance * h;
            }
            stack.add(current++);
        }
        return res;
    }


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int trapUsingTwoPointers(int[] height) {

        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }


                                                                      //                _
                                                                      //        _      | |_   _
    public static void main(String[] args) {                          //    _  | |_   _|   |_| |_
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // ._| |_|   |_|           |.

        System.out.println(trap(height));
        System.out.println(trapUsingDP(height));
        System.out.println(trapUsingStack(height));
        System.out.println(trapUsingTwoPointers(height));
    }
}
