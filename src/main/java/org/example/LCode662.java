package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCode662 {

    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> level = new ArrayDeque<>();
        root.val = 0;
        level.add(root);
        int maxWidth = 0;

        while (!level.isEmpty()) {
            Deque<TreeNode> nextLevel = new ArrayDeque<>();
            maxWidth = Math.max(maxWidth, level.peekLast().val - level.peekFirst().val + 1);

            while (!level.isEmpty()) {
                var curr = level.pollFirst();
                if (curr.left != null) {
                    curr.left.val = 2*curr.val + 1;
                    nextLevel.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = 2*curr.val + 2;
                    nextLevel.add(curr.right);
                }
            }

            level = nextLevel;
        }

        return maxWidth;
    }

}
