class Solution {
    public int maxLength(List<String> arr) {
         return solve(arr, 0, "");
    }
    
    
    public int solve(List<String> arr, int i, String soFar)
    {
        if(i == arr.size())
        {
            if(isValid(soFar))
            {
                return soFar.length();
            }
            return 0;
        }
        
        int size1 = solve(arr, i+1, soFar);
        int size2 = solve(arr, i+1, soFar+arr.get(i));
        
        return Math.max(size1, size2);

    }
    
    
    public boolean isValid(String s)
    {
        int[] freq = new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            int val = s.charAt(i) - 'a';
            freq[val]++;
            
            if(freq[val]>1)
            {
                return false;
            }
        }
        
        return true;
    }
}
