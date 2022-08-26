class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
         Arrays.sort(nums);
        return solve(nums);
    }
    
    private ArrayList<Integer> solve(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev = 0;prev < i;prev++){
                if(arr[i] % arr[prev] == 0 &&  1+dp[prev] > dp[i]){
                    dp[i] =  1+ dp[prev];
                    hash[i] = prev;
                }
            }
        }
        
        int max = 1;
        int max_index = 0;
        for(int i=0;i<n;i++){
            if(dp[i] > max){
                max = dp[i];
                max_index = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int prev = 0;
        while(true){
            result.add(arr[max_index]);
            prev = max_index;
            max_index = hash[max_index];
            if(prev == max_index){
                break;
            }
        }
        Collections.sort(result);
        return result;
    }
}
