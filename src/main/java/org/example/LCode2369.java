package org.example;

public class LCode2369 {

    public boolean validPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        var dp = new boolean[nums.length];
        dp[0] = false;
        dp[1] = nums[0] == nums[1];

        if (nums.length == 2) {
            return dp[1];
        }

        for (int i = 2 ; i < dp.length ; i++) {
            if (nums[i] == nums[i-1]) {
                dp[i] = dp[i] || dp[i-2];
            }
            if (nums[i] == nums[i-1] & nums[i-1] == nums[i-2]) {
                if (i-3 >=0) {
                    dp[i] = dp[i] || dp[i-3];
                } else {
                    dp[i] = true;
                }
            }
            if (nums[i] == nums[i-1] + 1 && nums[i-1] == nums[i-2] + 1) {
                if (i-3 >= 0) {
                    dp[i] = dp[i] || dp[i-3];
                } else {
                    dp[i] = true;
                }
            }
        }

        return dp[dp.length - 1];
    }

}
