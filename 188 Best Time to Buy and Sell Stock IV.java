/*
Best Time to Buy and Sell Stock IV

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len < 2 || k <= 0){
            return 0;
        }
        if(k > len / 2){
            int result = 0;
            for(int i = 1; i < len; i++){
                result += Math.max(prices[i] - prices[i - 1], 0);
            }
            return result;
        }
        
        int[][] local = new int[len][k + 1];    // local[i][j]: sell the kth time on the ith day
        int[][] global = new int[len][k + 1];   // global[i][j]: sell kth times before the ith day
        for(int i = 1; i < len; i++){
            int diff = prices[i] - prices[i - 1];
            for(int j = 1; j <= k; j++){
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + diff;
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[len - 1][k];
    }
}