/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.tree.binary;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 1
     * 2                3
     * 4        5       6       7
     * 8    9   10  11  12  13  14  15
     *
     * @return
     */
    public static TreeNode sampleTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8, null, null),
                                new TreeNode(9, null, null)),
                        new TreeNode(5,
                                new TreeNode(10, null, null),
                                new TreeNode(11, null, null))),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12, null, null),
                                new TreeNode(13, null, null)),
                        new TreeNode(7,
                                new TreeNode(14, null, null),
                                new TreeNode(15, null, null))));
        return root;
    }
}
