package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LCode621 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        int[] frequencies = new int[26];

        for (char taskLabel : tasks) {
            frequencies[taskLabel - 'A'] += 1;
        }

        Arrays.sort(frequencies);

        int countMaxFreqElements = 1;

        for (int i = frequencies.length - 2 ; i >= 0 ; i--) {
            if (frequencies[i] == frequencies[i+1]) {
                countMaxFreqElements += 1;
            } else {
                break;
            }
        }

        return Math.max(((frequencies[frequencies.length - 1] - 1) * (n + 1)) + countMaxFreqElements, tasks.length);
    }

}
