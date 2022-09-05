class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger) {
        return true;
    }
    
    int sum = maxChoosableInteger * (maxChoosableInteger+1) / 2;
    if(desiredTotal > sum) {
        return false;
    } else if(desiredTotal == sum) {
        return maxChoosableInteger%2 != 0;
    }
            
    int bitMask = 1 << (maxChoosableInteger+1);
    int[] dp = new int[bitMask];
    return canIWin(0, maxChoosableInteger, desiredTotal, 1, dp);  
}

public boolean canIWin(int bitMask, int maxInteger, int target, int turn, int[] dp) {
    if(target <= 0) {
        return turn != 1;
    }
    
    if(dp[bitMask] != 0)
        return dp[bitMask] == 1;
    
    boolean canWin = false;
    boolean willWin = true;
    for(int i=1; i<= maxInteger; i++) {
        if((bitMask&(1<<i)) == 0) {
            boolean wins = canIWin(bitMask|(1<<i), maxInteger, target-i, -1*turn, dp);
            canWin = canWin || wins;
            willWin = willWin && wins;
        }
    }
    
    boolean iWin = turn == 1 ? canWin : willWin;
    dp[bitMask] = iWin ? 1 : -1;
    return iWin;
    }
}
