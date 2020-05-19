/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class P0242ValidAnagram {
    public static void main(String[] args) {
        P0242ValidAnagram validAnagram = new P0242ValidAnagram();
        System.out.println(validAnagram.isAnagram2("aabbcc", "abcacb"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) != null ? map.get(c) + 1 : 1);
        }
        for (char c : t.toCharArray()) {
            if (map.get(c) == null) {
                return false;
            } else {
                int count = map.get(c) - 1;
                if (count <= 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (count[c - 'a'] <= 0) {
                return false;
            }
            count[c - 'a']--;

        }
        return true;
    }
}
