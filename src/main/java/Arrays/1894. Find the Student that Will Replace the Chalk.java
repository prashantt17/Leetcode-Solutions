class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
    
    long[] chalkUsed = new long[len];
    long currSum=0;
    
    for(int i=0;i<len;i++){
        chalkUsed[i] = currSum+chalk[i];
        currSum = currSum+chalk[i];
    }
    
    long totalChalk = chalkUsed[len-1];
    
    long remainingChalk = k % totalChalk;
    int low=0;
    int high = len-1;
    
    int possibleStudent =0;
    
    while(low <= high){
        
        int mid = low+(high-low)/2;
        if(chalkUsed[mid] == remainingChalk){
            possibleStudent = mid+1;
            return possibleStudent;
        }
        if(chalkUsed[mid] <remainingChalk){
            low=mid+1;
            possibleStudent = mid+1;
            
        }
        if(chalkUsed [mid] > remainingChalk){
            high = mid-1;
        }
    }
    
    return possibleStudent;
    }
}
