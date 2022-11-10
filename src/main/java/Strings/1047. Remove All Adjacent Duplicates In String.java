class Solution {
    public String removeDuplicates(String s) {
         Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length() ;i++){
            if(!st.isEmpty()){
                if(st.peek() == s.charAt(i)){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder ns = new StringBuilder("");
        while(!st.isEmpty()){
            ns.append(st.pop());
        }
        return ns.reverse().toString();
    }
}
