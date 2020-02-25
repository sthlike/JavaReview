/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.tree.binary.visit;

import com.sthlike.algorithm.tree.binary.TreeNode;

import java.util.Stack;

public class PreOrder {
    public static void preOrderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderVisit(root.left);
        preOrderVisit(root.right);
    }

    public static void preOrderVisitNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.val + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
}
