package org.example;

public class LCode121 {
    public int maxProfit(int[] prices) {
        int prefixMin = prices[0];
        int maxProfit = 0;
        for (int i = 1 ; i < prices.length ; i++) {
            int currentMaxProfit = prices[i] - prefixMin;
            maxProfit = Math.max(maxProfit, currentMaxProfit);
            prefixMin = Math.min(prefixMin, prices[i]);
        }

        return maxProfit;
    }
}
