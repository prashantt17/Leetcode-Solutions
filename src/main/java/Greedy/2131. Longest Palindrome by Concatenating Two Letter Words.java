class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap();

    for(String c : words){
        map.put(c, map.getOrDefault(c,0)+1);
    }
    
    int count=0;
    int ans = 0;
    for(Map.Entry<String,Integer> ent : map.entrySet()){
        
        String x = ent.getKey();
        int val = ent.getValue();
        StringBuilder sb=new StringBuilder(x);  
        String rev = sb.reverse().toString();  
        
        if(map.containsKey(rev)){
            int revVal = map.get(rev) ;
            
            if(rev.equals(x)){
                if(revVal%2 !=0){
                    ans =ans + 2*(revVal-1);
                    count++;
                    map.put(rev, map.get(rev)-1);
                }else{
                    ans = ans+ 2*revVal;
                }
            }else{
                int min = Math.min(revVal, val);
                ans= ans+ 4*min;
                map.put(x, map.get(x)-min);
                map.put(rev, map.get(rev)-min);
                
            }
            
        }
        
    }
    if(count>0){
        ans = ans+2;
    }
    
    return ans;
    }
}
