/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack <Character> s1 = new Stack<>();
        Stack <Character> s2 = new Stack<>();
        int n1 = s.length();
        int n2 = t.length();
        for(int i=0;i<n1;i++){
            if(s.charAt(i)=='#'){
                if(!s1.isEmpty())
                s1.pop();
            }
            else {
            s1.push(s.charAt(i));
            }
        }
        for(int i=0;i<n2;i++){
            if(t.charAt(i)=='#'){
                if(!s2.isEmpty())
                s2.pop();
            }else 
            s2.push(t.charAt(i));
        }
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.pop()!=s2.pop()){
                return false;
            }
        }
        if(!s1.isEmpty() || !s2.isEmpty()){
            return false;
        }
        return true;
    }
}
