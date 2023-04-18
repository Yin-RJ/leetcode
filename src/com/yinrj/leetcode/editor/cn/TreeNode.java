package com.yinrj.leetcode.editor.cn;

/**
 * @author yinrongjie
 * @date 2023/4/18
 * @name TreeNode
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
