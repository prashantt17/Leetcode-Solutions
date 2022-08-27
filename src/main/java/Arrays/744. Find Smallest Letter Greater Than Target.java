class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int val= target;
        for(int i=0;i<letters.length;i++){
            char ch= letters[i];
            int  valCh= ch;
            if(valCh>val) return ch;
        }
        
        return letters[0]; 
    }
}
