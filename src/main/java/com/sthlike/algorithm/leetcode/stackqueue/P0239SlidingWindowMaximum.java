/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.stackqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * Given an array nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class P0239SlidingWindowMaximum {
    public static void main(String[] args) {
        P0239SlidingWindowMaximum maxWindow = new P0239SlidingWindowMaximum();
        System.out.println(Arrays.toString(
                maxWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1)
        ));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return new int[]{};
        }
        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int rIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && dq.peek() <= i - k) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.add(i);
            if (i >= k - 1) {
                result[rIndex++] = nums[dq.peek()];
            }
        }
        return result;
    }
}
