class Solution {
    public List<String> generateParenthesis(int n) {
        
    List<String> parentheses = new ArrayList<>();
        helper(parentheses, "", 0, 0, n);
        return parentheses;
    }
    
    public void helper(List<String> parentheses, String str, int open, int close, int max){
        // Base case
		if(str.length() == 2*max){
            parentheses.add(str);
            return;
        }
        
	    if(open < max){
            helper(parentheses, str+"(", open+1, close, max);
        }
	    if(close < open){
            helper(parentheses, str+")", open, close+1, max);
        }
    }
}
