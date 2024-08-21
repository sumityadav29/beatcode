package org.example;

import java.util.Stack;

public class LCode20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (var c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }

}
