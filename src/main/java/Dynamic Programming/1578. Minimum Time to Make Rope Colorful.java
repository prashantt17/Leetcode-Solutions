class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int max = neededTime[i];
            int sum = neededTime[i];
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                max = Math.max(max, neededTime[j]);
                sum += neededTime[j];
                j++;
            }
            ans += sum - max;
            i = j;
        }
        return ans;
    }
}
