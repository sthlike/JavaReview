/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.tree.binary.visit;

import com.sthlike.algorithm.tree.binary.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.sampleTree();

        System.out.println("pre order visit null tree");
        PreOrder.preOrderVisit(null);
        System.out.println("\npre order visit in recursive");
        PreOrder.preOrderVisit(root);
        System.out.println("\npre order visit in non recursive");
        PreOrder.preOrderVisitNonRecursive(root);

        System.out.println("\nin order visit null tree");
        InOrder.inOrderVisit(null);
        System.out.println("\nin order visit in recursive");
        InOrder.inOrderVisit(root);
        System.out.println("\nin order visit in non recursive");
        InOrder.inOrderVisitNonRecursive(root);

        System.out.println("\npost order visit null tree");
        PostOrder.postOrderVisit(null);
        System.out.println("\npost order visit in recursive");
        PostOrder.postOrderVisit(root);
        System.out.println("\npost order visit in non recursive whit 2 stacks");
        PostOrder.postOrderVisitWith2Stacks(root);
        System.out.println("\npost order visit in non recursive whit 1 stacks");
        PostOrder.postOrderVisitWith1Stacks(root);
    }
}
