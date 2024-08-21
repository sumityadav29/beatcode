package org.example;

public class LCode572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }

        boolean isSameTree = isSameTree(root, subRoot);
        if (isSameTree) {
            return true;
        }

        isSameTree = isSubtree(root.left, subRoot);

        if (isSameTree) {
            return true;
        }

        return isSubtree(root.right, subRoot);

    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
