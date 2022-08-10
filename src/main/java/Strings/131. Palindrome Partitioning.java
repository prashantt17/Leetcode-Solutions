class Solution {
    public List<List<String>> partition(String s) {
       return palinPartition(s,0,0,new ArrayList<>(),new ArrayList<>());
    }
    public List<List<String>> palinPartition(String str,int s,int e,List<String> partition,List<List<String>> ans) {
        if (s==str.length() && e==str.length()) {
            ans.add(new ArrayList<>(partition));
            return ans;
        }
        if (e==str.length()) {
            return ans;
        }
        if (isPalindrome(str,s,e)) { 
            partition.add(str.substring(s,e+1));
            palinPartition(str,e+1,e+1,partition,ans);
            partition.remove(partition.size()-1);
        }
        palinPartition(str,s,e+1,partition,ans);
        return ans;  
    }
    public boolean isPalindrome(String partitioned,int s,int e) {
        while (s<e) {
            if (partitioned.charAt(s)!=partitioned.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true; 
    }
}
