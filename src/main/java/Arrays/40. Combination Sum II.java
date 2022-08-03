class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          List<List<Integer>> ans = new ArrayList<>();  
        Arrays.sort(candidates);
        backtrack(candidates,0, target, new ArrayList<>() , ans);
        return ans;    
    }

    public void backtrack(int [] candidates,int start, int target, ArrayList<Integer> asf, List<List<Integer>> ans){
        if (target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<Integer>(asf));
            return;
        }
       
       for(int i = start ; i < candidates.length; i++){
           if(i > start && candidates[i-1] == candidates[i])continue;
           asf.add(candidates[i]);
           backtrack(candidates, i+1, target - candidates[i], asf , ans); 
           asf.remove(asf.size()-1);          
       }
        
    
    }
}
