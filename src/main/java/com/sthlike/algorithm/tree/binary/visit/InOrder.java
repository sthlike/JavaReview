/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.tree.binary.visit;

import com.sthlike.algorithm.tree.binary.TreeNode;

import java.util.Stack;

public class InOrder {
    public static void inOrderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderVisit(root.left);
        System.out.print(root.val + " ");
        inOrderVisit(root.right);
    }

    public static void inOrderVisitNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode top = null;
        TreeNode current = root;
        while (!(current == null && stack.isEmpty())) {
            if (current == null) {
                top = stack.pop();
                System.out.print(top.val + " ");
                current = top.right;
                continue;
            }
            stack.push(current);
            current = current.left;
        }
    }
}
