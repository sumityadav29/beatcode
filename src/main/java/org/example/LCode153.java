package org.example;

public class LCode153 {

    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j-i)/2;

            if (nums[i] <= nums[mid] && nums[mid] <= nums[j]) {
                j = mid;
            } else if (nums[i] >= nums[j] && nums[j] >= nums[mid]) {
                j = mid;
            } else {
                i = mid+1;
            }
        }

        return nums[i];
    }

}
