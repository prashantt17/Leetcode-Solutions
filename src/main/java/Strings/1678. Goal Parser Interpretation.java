class Solution {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        
        char cArray[] =  command.toCharArray();
        
        for(int i = 0; i < cArray.length; ++i){
            if(cArray[i] == 'G') ans.append("G");
            else if(cArray[i] == '('){
                if(cArray[i+1] == ')')    ans.append("o");
                else    ans.append("al");
            }
        }
         
        return ans.toString();
    }
}
