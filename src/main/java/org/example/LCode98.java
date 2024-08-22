package org.example;

import java.util.ArrayList;
import java.util.List;

public class LCode98 {

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        for (int i = 1 ; i < inorder.size() ; i++) {
            if (inorder.get(i-1) >= inorder.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void getInorder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }

}
