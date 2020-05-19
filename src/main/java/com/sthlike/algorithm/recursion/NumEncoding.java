/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.recursion;

/**
 * 一条包含字母A-Z的消息通过以下方式进行了编码
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数
 */
public class NumEncoding {
    static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        return decode(chars, chars.length - 1);
    }

    public static void main(String[] main) {
        System.out.println(numDecodings("11232526"));
    }

    static int decode(char[] chars, int index) {
        if (index <= 0) {
            return 1;
        }

        int count = 0;

        char curr = chars[index];
        char prev = chars[index - 1];

        if (curr > '0') {
            count = decode(chars, index - 1);
        }

        if (prev == '1' || (prev == '2' && curr <= '6')) {
            count += decode(chars, index - 2);
        }
        return count;
    }
}
