package org.example;

import java.util.HashMap;

public class LCode740 {

    public int deleteAndEarn(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        int maxNum = 0;
        for (var num : nums) {
            maxNum = Math.max(maxNum, num);
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        var dp = new int[maxNum+1];
        dp[1] = map.getOrDefault(1, 0);

        for (int i = 2 ; i <= maxNum ; i++) {
            dp[i] = Math.max(dp[i-1], map.getOrDefault(i, 0) + dp[i-2]);
        }

        return dp[maxNum];
    }

}
