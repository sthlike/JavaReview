/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.list;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * Given an m x n matrix of positive integers representing
 * the height of each unit cell in a 2D elevation map,
 * compute the volume of water it is able to trap after raining.
 * <p>
 * Example:
 * <p>
 * Given the following 3x6 height map:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * Return 4.
 */
public class P0407TrappingRainWater {
    public static void main(String[] args) {
        int[][] heightMap = new int[][]{{1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        System.out.println(trapRainWater(heightMap));
    }

    public static int trapRainWater(int[][] heightMap) {
        int height = heightMap.length;
        int width = heightMap[0].length;
        int[][] up = new int[height][width],
                down = new int[height][width],
                left = new int[height][width],
                right = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    left[i][j] = heightMap[i][j];
                    right[i][width - 1] = heightMap[i][width - 1];
                } else {
                    left[i][j] = Math.max(heightMap[i][j], left[i][j - 1]);
                    right[i][width - 1 - j] = Math.max(heightMap[i][width - 1 - j], right[i][width - 1 - j + 1]);
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0) {
                    up[j][i] = heightMap[j][i];
                    down[height - 1][i] = heightMap[height - 1][i];
                } else {
                    up[j][i] = Math.max(heightMap[j][i], up[j - 1][i]);
                    down[height - 1 - j][i] = Math.max(heightMap[height - 1 - j][i], down[height - 1 - j + 1][i]);
                }
            }
        }
        int total = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                total += Math.min(up[i][j],
                        Math.min(down[i][j],
                                Math.min(left[i][j], right[i][j])))
                        - heightMap[i][j];
            }
        }
        return total;
    }

    private static void print(int[][] ints) {
        for (int[] is : ints) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
    }
}
