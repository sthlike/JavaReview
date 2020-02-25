/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.tree.binary.visit;

import com.sthlike.algorithm.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * breadth first search
 */
public class BFS {

    public static void breadthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode last = null;
        TreeNode nextLast = null;
        TreeNode current = null;
        last = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.add(current.left);
                nextLast = current.left;
            }
            if (current.right != null) {
                queue.add(current.right);
                nextLast = current.right;
            }
            if (last == current) {
                System.out.println();
                last = nextLast;
            }
        }
    }
}
