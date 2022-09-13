class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        int lowRem = low%2;
        int highRem = high%2;
       
        if ((lowRem == 1 && highRem == 1) || (lowRem == 0 && highRem == 1)) {
            count = (high/2) - (low/2) + 1;
        } else {
            count =  (high/2) - (low/2);
        }
        return count;
    }
}
