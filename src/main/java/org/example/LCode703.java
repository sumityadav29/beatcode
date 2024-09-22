package org.example;

import java.util.PriorityQueue;

public class LCode703 {

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private int size;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for (int num : nums) {
            priorityQueue.add(num);
        }
        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
    }

    public int add(int val) {
        priorityQueue.add(val);

        if (priorityQueue.size() > this.size) {
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }

}
