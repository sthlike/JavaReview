/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.common;

public class ListNode {
    public ListNode next;
    public int data;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf("{%d}->", head.data);
            head = head.next;
        }
        System.out.println("null");
    }
}
