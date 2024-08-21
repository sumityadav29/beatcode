package org.example;

import java.util.HashMap;
import java.util.Map;

public class LCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> freq = HashMap.newHashMap(200);
        freq.put(s.charAt(0), 0);
        int maxLength = 0;

        int i = 0, j = 0;
        boolean hasDuplicate = false;

        while (i <= j && j < s.length()) {
            if (hasDuplicate) {
                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) - 1);
                if (freq.get(s.charAt(i)) == 1) {
                    hasDuplicate = false;
                }
                i++;
            } else {
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
                if (freq.get(s.charAt(j)) == 2) {
                    hasDuplicate = true;
                } else {
                    maxLength = Math.max(maxLength, j-i+1);
                }
                j++;
            }
        }

        return maxLength;
    }

}
