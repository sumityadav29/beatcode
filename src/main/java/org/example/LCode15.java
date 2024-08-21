package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length - 2) {
            int a = nums[i];
            int j = i+1, k = nums.length - 1;
            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                if (a + b + c == 0) {
                    res.add(List.of(a, b, c));
                    j++;
                    while (nums[j-1] == nums[j] && j < k) {
                        j++;
                    }
                } else if (a + b + c < 0) {
                    j++;
                    while (nums[j-1] == nums[j] && j < k) {
                        j++;
                    }
                } else {
                    k--;
                }
            }
            i++;
            while (nums[i-1] == nums[i] && i < j) {
                i++;
            }
        }

        return res;
    }

}
