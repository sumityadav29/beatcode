package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null && !queue.isEmpty()) {
                res.add(new ArrayList<>());
                queue.add(null);
            } else if (current != null) {
                res.get(res.size() - 1).add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return res;
    }

}
