class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        if(strs.length == 0|| strs == null){
            return longestCommonPrefix;
        }
        
        int index = 0;
        for(char c:strs[0].toCharArray()){
            for(int i=1;i<strs.length;i++){
                if(index>=strs[i].length() || c != strs[i].charAt(index)){
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix +=c;
            index++;
        }
        return longestCommonPrefix;
    }
}
