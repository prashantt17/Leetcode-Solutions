class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int len : matchsticks) {
            sum += len;
        }
        
        boolean[] picked = new boolean[matchsticks.length];
        
        if(sum%4 != 0) return false;
        
        return backtracking(matchsticks, 4, sum/4, picked, 0, 0);
        
    }
    
    public boolean backtracking(int[] matchsticks, int sideLeft, int target, boolean[] picked, int start, int subSum ) {
        
        if(sideLeft==1) return true;
        
        if(subSum == target) {
            return backtracking(matchsticks, sideLeft-1, target, picked, 0, 0);
        }
        
        for(int i=start; i<matchsticks.length; i++) {
            
            if(picked[i] || subSum+matchsticks[i]>target) continue;
            
            subSum += matchsticks[i];
            picked[i] = true;
            
            if (backtracking(matchsticks, sideLeft, target, picked, i+1, subSum)) return true;
            
            picked[i] = false;
            subSum -= matchsticks[i];
            
        }
        
        return false;
    }
}
