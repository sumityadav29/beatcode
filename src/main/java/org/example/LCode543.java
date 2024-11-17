package org.example;

public class LCode543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        depth(root);

        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var left = depth(root.left);
        var right = depth(root.right);

        max = Math.max(max, left+right);

        return Math.max(left, right) + 1;
    }

}
