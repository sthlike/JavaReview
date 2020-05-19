/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.list;

import com.sthlike.algorithm.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */
public class P0141N0142LikedListCycle {
    public static void main(String[] args) {
        ListNode a, b, c, d, e, f;
        a = new ListNode(1, null);
        b = new ListNode(2, null);
        c = new ListNode(3, null);
        d = new ListNode(4, null);
        e = new ListNode(5, null);
        f = new ListNode(6, null);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = c;
        P0141N0142LikedListCycle likedListCycle = new P0141N0142LikedListCycle();
        System.out.println(likedListCycle.hasCycle(a));
        System.out.println(likedListCycle.detectCycle(a).data);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) {
                ListNode newHead = head;
                while (newHead != slow.next) {
                    slow = slow.next;
                    newHead = newHead.next;
                }
                return newHead;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
