package org.example;

import java.util.*;

public class LCode140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), new HashMap<>());
    }

    public List<String> wordBreak(String remainingStr, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(remainingStr)) {
            return memo.get(remainingStr);
        }

        if (remainingStr.isEmpty()) {
            return List.of("");
        }

        List<String> results = new ArrayList<>();

        for (int i = 1 ; i <= remainingStr.length() ; i++) {
            String candidateWord = remainingStr.substring(0, i);
            if (wordDict.contains(candidateWord)) {
                List<String> subSentences = wordBreak(remainingStr.substring(i), wordDict, memo);
                for (String subSentence : subSentences) {
                    results.add(candidateWord + (subSentence.isEmpty() ? "" : " ") + subSentence);
                }
            }
        }

        memo.put(remainingStr, results);
        return results;
    }

}
