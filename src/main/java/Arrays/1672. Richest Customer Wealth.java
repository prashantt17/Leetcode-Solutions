class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int numberOfCustomers = accounts.length;
        for(int i=0; i<numberOfCustomers; i++) {
            int tempWealth = 0;
        
            for (int j = 0; j <accounts[i].length ; j++) {
                tempWealth+=accounts[i][j];
            }
            maxWealth = Math.max(maxWealth,tempWealth);
        }
        return maxWealth;
    }
}
