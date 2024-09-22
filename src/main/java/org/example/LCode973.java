package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LCode973 {

    public int[][] kClosest(int[][] points, int k) {
        Queue<double []> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o[0]));

        for (int[] point : points) {
            double distance = Math.sqrt((point[0]*point[0]) + (point[1]*point[1]));
            queue.add(new double[] {distance, point[0], point[1]});
        }

        int[][] res = new int[k][];

        for (int i = 0 ; i < k ; i++) {
            res[i] = new int[] {(int) queue.peek()[1], (int) queue.peek()[2]};
            queue.poll();
        }

        return res;
    }

}
