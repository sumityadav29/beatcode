package org.example;

import java.util.*;

public class LCode1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> elementToFrequencyMap = new HashMap<>();

        for (int i = 0  ; i < arr.length ; i++) {
            elementToFrequencyMap.put(arr[i], elementToFrequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(elementToFrequencyMap.values().stream().toList());

        Collections.sort(frequencies);

        int removedElements = 0;
        for (int i = 0 ; i < frequencies.size() ; i++) {
            removedElements = removedElements + frequencies.get(i);

            if (removedElements > k) {
                return frequencies.size() - i;
            }
        }

        return 0;
    }

}
