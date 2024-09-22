package org.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class LCode1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (var stoneWeight : stones) {
            priorityQueue.add(stoneWeight);
        }

        while (priorityQueue.size() > 1) {
            int weightStone1 = priorityQueue.poll();
            int weightStone2 = priorityQueue.poll();

            if (weightStone1 != weightStone2) {
                priorityQueue.add(Math.abs(weightStone1 - weightStone2));
            }
        }

        return priorityQueue.size() == 0 ? 0 : priorityQueue.poll();
    }

}
