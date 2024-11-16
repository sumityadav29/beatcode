package org.example;

import java.util.HashMap;
import java.util.Stack;

public class LCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var stack = new Stack<Integer>();
        stack.push(nums2[nums2.length - 1]);
        var nextGreater = new int[nums2.length];
        nextGreater[nextGreater.length - 1] = -1;

        for(int i = nums2.length - 2 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }

        var res = new int[nums1.length];
        for (int i = 0 ; i < nums1.length ; i++) {
            for (int j = 0 ; j < nums2.length ; j++) {
                if (nums1[i] == nums2[j]) {
                    res[i] = nextGreater[j];
                    break;
                }
            }
        }

        return res;
    }

}
