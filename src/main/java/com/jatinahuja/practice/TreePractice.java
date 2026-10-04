package com.jatinahuja.practice;

import java.util.ArrayList;
import java.util.List;

public final class TreePractice {
    private TreePractice() {
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static boolean isValidBST(TreeNode node, long minimum, long maximum) {
        if (node == null) {
            return true;
        }
        if (node.val <= minimum || node.val >= maximum) {
            return false;
        }
        return isValidBST(node.left, minimum, node.val)
                && isValidBST(node.right, node.val, maximum);
    }

    private static void inorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.val);
            inorder(node.right, result);
        }
    }

    public static final class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
