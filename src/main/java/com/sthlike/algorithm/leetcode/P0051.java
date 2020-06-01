/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class P0051 {
    int count = 0;

    public static void main(String[] args) {
        P0051 p = new P0051();
        List<List<String>> res = p.solveNQueens(4);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //dfs(n, new ArrayList<>(), new HashSet<>(), new HashSet<>());
        //dfs(n, res, new ArrayList<>(), new HashSet<>(), new HashSet<>());
        dfs(n, 0, 0, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int row, int col, int slash, int backslash, List<Integer> cols) {
        if (row >= n) {
            count++;
            printOneSolver(convertBitColsToIntCols(cols));
            return;
        }
        int currentState = (~(col | slash | backslash)) & ((1 << n) - 1);
        while (currentState > 0) {
            int currentCol = currentState & -currentState;
            cols.add(currentCol);
            dfs(n, row + 1, col | currentCol,
                    (slash | currentCol) << 1, (backslash | currentCol) >> 1, cols);
            cols.remove(Integer.valueOf(currentCol));
            currentState &= currentState - 1;
        }
    }

    private void dfs(int n, List<List<String>> res, List<Integer> cols, Set<Integer> xySum, Set<Integer> xyDiff) {
        if (cols.size() >= n) {
            List<String> oneResolver = new ArrayList<>();
            for (int i = 0; i < cols.size(); i++) {
                oneResolver.add(".".repeat(cols.get(i))
                        + "Q"
                        + ".".repeat(cols.size() - cols.get(i) - 1));
            }
            res.add(oneResolver);
            return;
        }
        int row = cols.size();
        for (int col = 0; col < n; col++) {
            if (!cols.contains(col) && !xySum.contains(row + col) && !xyDiff.contains(row - col)) {
                cols.add(col);
                xySum.add(row + col);
                xyDiff.add(row - col);
                dfs(n, res, cols, xySum, xyDiff);
                cols.remove(Integer.valueOf(col));
                xySum.remove(Integer.valueOf(row + col));
                xyDiff.remove(Integer.valueOf(row - col));
            }
        }
    }

    /**
     * @param n
     * @param cols
     * @param xySum
     * @param xyDiff
     */
    private void dfs(int n, List<Integer> cols, Set<Integer> xySum, Set<Integer> xyDiff) {
        if (cols.size() >= n) {
            printOneSolver(cols);
            return;
        }
        int row = cols.size();
        for (int col = 0; col < n; col++) {
            if (!cols.contains(col) && !xySum.contains(row + col) && !xyDiff.contains(row - col)) {
                cols.add(col);
                xySum.add(row + col);
                xyDiff.add(row - col);
                dfs(n, cols, xySum, xyDiff);
                cols.remove(Integer.valueOf(col));
                xySum.remove(Integer.valueOf(row + col));
                xyDiff.remove(Integer.valueOf(row - col));
            }
        }
    }

    private void printOneSolver(List<Integer> cols) {
        for (int i = 0; i < cols.size(); i++) {
            System.out.println(". ".repeat(cols.get(i))
                    + "Q "
                    + ". ".repeat(cols.size() - cols.get(i) - 1));
        }
        System.out.println();
    }

    private List<Integer> convertBitColsToIntCols(List<Integer> cols) {
        List<Integer> res = new ArrayList<>();
        int n = cols.size();
        for (Integer col : cols) {
            res.add(n - 1 - (int) (Math.log(col) / Math.log(2)));
        }
        return res;
    }
}
