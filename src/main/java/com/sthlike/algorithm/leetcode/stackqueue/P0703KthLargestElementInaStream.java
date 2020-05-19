/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.stackqueue;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor
 * which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream.
 * For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class P0703KthLargestElementInaStream {
    private int k;
    private PriorityQueue<Integer> pq = null;

    public P0703KthLargestElementInaStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public static void main(String[] args) {
        P0703KthLargestElementInaStream kthLargest = new P0703KthLargestElementInaStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    public int add(int val) {
        if (this.pq.size() < k) {
            this.pq.add(val);
        } else if (this.pq.peek() < val) {
            this.pq.poll();
            this.pq.add(val);
        }

        return this.pq.peek();
    }
}
