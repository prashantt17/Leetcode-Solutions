class Solution {
    public String reverseWords(String s) {
        StringBuilder ans=ReverseWords(s);
         String Ans="";
       for(int i=0;i<ans.length();i++){
           Ans+=ans.charAt(i);
       }
        return Ans;
    }
    private static StringBuilder ReverseWords(String input){
        StringBuilder correct=removeSpaces(input);
        reverse(correct,0,correct.length()-1);
        int i=0,j=0;
        while(j<correct.length()){
            if(correct.charAt(j)==' '){
                reverse(correct, i, j - 1);
                i=j+1;
            }
            j++;
        }
        reverse(correct,i,j-1);
        return correct;
    }
    private static StringBuilder removeSpaces(String input){
        StringBuilder sb=new StringBuilder();
        int i=0;
        int start=-1;
        while(i<input.length()){
            if(input.charAt(i)==' ') i++;
            else{
                start=i;
                break;
            }
        }
        while (start<input.length()-1){
            if(input.charAt(start)==' ' && input.charAt(start+1)==' ') i++;
            else sb.append(input.charAt(start));
            start++;
        }
        if(input.charAt(start)!=' ') sb.append(input.charAt(start));
        return sb;
    }
    private static void reverse(StringBuilder sb,int i,int k){
        while(i<k){
            char temp=sb.charAt(i);
            sb.setCharAt(i,sb.charAt(k));
            sb.setCharAt(k,temp);
            i++;
            k--;
        }
    }
}
