/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/submissions/
 * <p>
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class P0011 {
    public static void main(String[] args) {
        P0011 p = new P0011();
        System.out.println(p.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(p.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        if (null == height || height.length < 2) {
            return 0;
        }

        int leftIndex = 0, rightIndex = height.length - 1;
        int area = 0;

        while (leftIndex < rightIndex) {
            area = Math.max(area, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return area;
    }

    public MaxArea maxArea2(int[] height) {
        if (null == height || height.length < 2) {
            return new MaxArea();
        }

        int leftIndex = 0, rightIndex = height.length - 1;
        int area = 0;
        MaxArea maxArea = new MaxArea();

        while (leftIndex < rightIndex) {
            area = Math.max(area, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (area > maxArea.maxArea) {
                maxArea.maxArea = area;
                maxArea.leftIndex = leftIndex;
                maxArea.rightIndex = rightIndex;
            }
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxArea;
    }

    public static class MaxArea {
        int leftIndex = 0;
        int rightIndex = 0;
        int maxArea = 0;

        @Override
        public String toString() {
            return String.format("leftIndex: %d, rightIndex: %d, maxArea = %d.", leftIndex, rightIndex, maxArea);
        }
    }
}
