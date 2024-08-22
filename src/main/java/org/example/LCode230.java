package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCode230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        List<TreeNode> inorder = new ArrayList<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            inorder.add(current);

            current = current.right;
        }

        return inorder.get(k - 1).val;
    }

}
