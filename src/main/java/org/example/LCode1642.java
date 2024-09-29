package org.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class LCode1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0 ; i < heights.length - 1 ; i++) {
            int heightDiff = heights[i+1] - heights[i];

            if (heightDiff > 0) {
                pq.add(heightDiff);
            }

            if (pq.size() > ladders) {
                bricks = bricks - pq.poll();
            }

            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }

}
