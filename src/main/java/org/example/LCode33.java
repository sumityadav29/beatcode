package org.example;

public class LCode33 {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[i] <= nums[mid]) {
                if (target >= nums[i] && target<= nums[mid]) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target<= nums[j]) {
                    i = mid;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }

}
