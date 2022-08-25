class Solution {
   public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(0);
        }
        
        HashSet<String> set = new HashSet<>();
        set.add(sb.toString());
        
        int limit = (int)Math.pow(k,n);
        dfs(sb,set,limit,n,k);
        
        return sb.toString();
    }
    
    public boolean dfs(StringBuilder sb,HashSet<String> set,int limit,int n,int k){
        if(set.size() == limit){
            return true;
        }
        
        String lnm1 = sb.substring(sb.length() - (n-1));
        for(int i=0;i<k;i++){
            String npwd = lnm1 + i;
            if(set.contains(npwd) == false){
                set.add(npwd);
                sb.append(i);
                boolean flag = dfs(sb,set,limit,n,k);
                if(flag == true){
                    return true;
                }
                
                set.remove(npwd);
                sb.deleteCharAt(sb.length() -1);
            }
        }
        return false;
    }
}
