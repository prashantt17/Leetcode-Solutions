class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i ++) {
            items[i][0] = difficulty[i];
            items[i][1] = profit[i];
        }
        Arrays.sort(items, (n1, n2) -> (n1[0] - n2[0]));
        int[] maxProfit = new int[n];

        
        for (int i = 0; i < n; i ++) {
            if (i == 0)
                maxProfit[i] = items[i][1];
            else
                maxProfit[i] = Math.max(maxProfit[i-1], items[i][1]);
        }
        

        int ret = 0;
        for (int w: worker) {
            ret += findLast(items, w, maxProfit);
        }
        
        return ret;
    }
    
    int findLast(int[][] items, int tar, int[] maxProfit) {
        int lf = 0, rh = items.length;
        while (lf < rh) {
            int mid = lf + (rh - lf) / 2;
            if (items[mid][0] > tar) {
                rh = mid;
            }
            else {
                lf = mid + 1;
            }
        }
        if (lf == 0)
            return 0;
        else
            return maxProfit[lf-1];
    }
}
