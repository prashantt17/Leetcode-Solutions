class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
    
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    
    ArrayList<Integer> currList = new ArrayList<Integer>();
    
    
    combinationSum(candidates , target , 0 , answer , currList , 0);
    
    return answer;
    }
    
     public static void combinationSum(int[]arr , int sum , int currsum , List<List<Integer>> answer , ArrayList<Integer> currList ,int index)
{
     // Base condition
    if(currsum == sum)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>(currList);
      
        answer.add(temp);
       
        return;
    }
     
     
    if(currsum >sum)
		return;
    
    for(int i=index ; i < arr.length;i++)
    {
        
        // Adding the current element to the list 
        currList.add(arr[i]);
        
        // Updating sum with current element 
        currsum=currsum+arr[i];
        
        combinationSum(arr , sum , currsum , answer , currList , i );
        
        currList.remove(currList.size()-1);
        
        currsum=currsum-arr[i];
      
    }
    return;
    
}
}
