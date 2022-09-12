class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        if(n == 0)
            return 0;
        
        Arrays.sort(tokens);
        int i=0;
        int j = n-1;
        int cur = 0;
        int max = 0;
        while(i<=j){
            if(power >= tokens[i]){
                power -= tokens[i];
                cur++;
                if(cur>max)
                    max = cur;
                i++;
            }
            else if(cur>=1){
                power += tokens[j];
                j--;
                cur--;
            }
            else
                break;
        }
        return max;
    }
}
