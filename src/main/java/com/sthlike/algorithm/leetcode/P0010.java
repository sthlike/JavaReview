/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode;

public class P0010 {
    public static void main(String[] args) {
        SolutionRecursion solutionRecursion = new SolutionRecursion();
        System.out.println(solutionRecursion.isMatch("aa", "a*b"));

        SolutionRecursionReverse solutionRecursionReverse = new SolutionRecursionReverse();
        System.out.println(solutionRecursionReverse.isMatch("aa", "bb"));

        SolutionDynamic solutionDynamic = new SolutionDynamic();
        System.out.println(solutionDynamic.isMatch("aa", "bb"));
    }

    static class SolutionDynamic {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            boolean[][] dp = new boolean[sLen + 1][pLen + 1];

            dp[0][0] = true;
            for (int pIndex = 1; pIndex <= pLen; pIndex++) {
                dp[0][pIndex] = pIndex > 1 && p.charAt(pIndex - 1) == '*' && dp[0][pIndex - 2];
            }

            for (int sIndex = 1; sIndex <= sLen; sIndex++) {
                for (int pIndex = 1; pIndex <= pLen; pIndex++) {
                    if (p.charAt(pIndex - 1) != '*') {
                        dp[sIndex][pIndex] = dp[sIndex - 1][pIndex - 1]
                                && isMatch(s.charAt(sIndex - 1), p.charAt(pIndex - 1));
                    } else {
                        dp[sIndex][pIndex] = dp[sIndex][pIndex - 2]
                                || dp[sIndex - 1][pIndex]
                                && isMatch(s.charAt(sIndex - 1), p.charAt(pIndex - 2));
                    }
                }
            }
            return dp[sLen][pLen];
        }

        private boolean isMatch(char s, char p) {
            return s == p || p == '.';
        }
    }

    static class SolutionRecursionReverse {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            return isMatch(s, s.length(), p, p.length());
        }

        private boolean isMatch(String s, int sIndex, String p, int pIndex) {
            if (pIndex == 0) {
                return sIndex == 0;
            }
            if (sIndex == 0) {
                return pIndex > 1 && p.charAt(pIndex - 1) == '*'
                        && isMatch(s, sIndex, p, pIndex - 2);
            }

            if (p.charAt(pIndex - 1) != '*') {
                return isMatch(s.charAt(sIndex - 1), p.charAt(pIndex - 1))
                        && isMatch(s, sIndex - 1, p, pIndex - 1);
            }
            return isMatch(s, sIndex, p, pIndex - 2)
                    || isMatch(s, sIndex - 1, p, pIndex)
                    && isMatch(s.charAt(sIndex - 1), p.charAt(pIndex - 2));
        }

        private boolean isMatch(char s, char p) {
            return s == p || p == '.';
        }
    }

    static class SolutionRecursion {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            return isMatch(s, 0, p, 0);
        }

        private boolean isMatch(String s, int sIndex, String p, int pIndex) {
            int sLen = s.length();
            int pLen = p.length();

            //is completed
            if (pIndex == pLen) {
                return sIndex == sLen;
            }

            // next char is not '*': must satisfy current char and recursive to next level
            if (pIndex == pLen - 1 || p.charAt(pIndex + 1) != '*') {
                return (sIndex < sLen)
                        && (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex))
                        && isMatch(s, sIndex + 1, p, pIndex + 1);
            }

            // next char is '*', if there are continuous s[sIndex] and all equal to p[pIndex],
            // continue trying
            if (pIndex < pLen - 1 && p.charAt(pIndex + 1) == '*') {
                while ((sIndex < sLen) && (p.charAt(pIndex) == '.'
                        || s.charAt(sIndex) == p.charAt(pIndex))) {
                    if (isMatch(s, sIndex, p, pIndex + 2)) {
                        return true;
                    }
                    sIndex++;
                }
            }
            return isMatch(s, sIndex, p, pIndex + 2);
        }
    }
}
