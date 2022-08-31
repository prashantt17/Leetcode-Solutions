class Solution {
     public static int Find_par(int u, int[] par){
        if(par[u] == u){
            return u;
        } 
        
        return par[u] = Find_par(par[u], par);
    }
    
    public static boolean isSimilar(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i) && ++count > 2){
                return false;
            }
        }
        
        return true;
    }
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int group = n;
        int[] par = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isSimilar(strs[i], strs[j])){
                    int p1 = Find_par(i, par);
                    int p2 = Find_par(j, par);
                
                    if(p1 != p2){
                        par[p2] = p1;
                        group -= 1;    
                    }
                }    
            }
        }
        
        return group;
    }
}
