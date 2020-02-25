/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.tree.binary.visit;

import com.sthlike.algorithm.tree.binary.TreeNode;

import java.util.Stack;

public class PostOrder {
    public static void postOrderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderVisit(root.left);
        postOrderVisit(root.right);
        System.out.print(root.val + " ");
    }

    public static void postOrderVisitWith2Stacks(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode current = null;
        s1.push(root);
        while (!s1.isEmpty()) {
            current = s1.pop();
            s2.push(current);
            if (current.left != null) {
                s1.push(current.left);
            }
            if (current.right != null) {
                s1.push(current.right);
            }
        }
        while (!s2.isEmpty()) {
            current = s2.pop();
            System.out.print(current.val + " ");
        }
    }

    public static void postOrderVisitWith1Stacks(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode top = null;
        TreeNode current = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            top = stack.peek();
            if (top.left != null && current != top.left && current != top.right) {
                stack.push(top.left);
            } else if (top.right != null && current != top.right) {
                stack.push(top.right);
            } else {
                top = stack.pop();
                System.out.print(top.val + " ");
                current = top;
            }
        }
    }
}
