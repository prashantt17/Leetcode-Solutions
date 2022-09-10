class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        
        int[] buy = new int[k]; 
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        
        for (int i : prices) {
            buy[0] = Math.max(buy[0], i * -1);
            sell[0] = Math.max(sell[0], buy[0] + i);
            for (int j = 1; j < k; j++) { 
                buy[j] = Math.max(buy[j], sell[j - 1] - i);
                sell[j] = Math.max(sell[j], buy[j] + i);
            }
        }
        return sell[k - 1];
    }
}
