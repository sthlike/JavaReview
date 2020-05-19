/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.list;

import com.sthlike.algorithm.leetcode.common.ListNode;

public class P0024SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4, null))));
        P0024SwapPairs swapPairs = new P0024SwapPairs();
        ListNode.printList(head);
        ListNode.printList(swapPairs.swapPairs(head));

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        ListNode one = null, two = null;
        while (current.next != null && current.next.next != null) {
            one = current.next;
            two = current.next.next;
            one.next = two.next;
            current.next = two;
            current.next.next = one;
            current = one;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }
}
