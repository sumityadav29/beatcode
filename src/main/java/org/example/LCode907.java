package org.example;

import java.util.Stack;

public class LCode907 {

    public int sumSubarrayMins(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        long res = 0;
        long mod = (int) 1e9 + 7;
        for (int i = 0; i <= arr.length; i++) {
            while(!stack.isEmpty() && (i == arr.length || arr[stack.peek()] > arr[i])) {
                long topi = stack.pop();
                long right = i - topi;
                long leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                long left = topi - leftBoundary;
                var numArrays = (left*right);
                res = (res + numArrays*arr[(int) topi])%mod;
            }
            stack.push(i);
        }

        return (int) res;
    }

}
