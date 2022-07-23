/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true

*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
      HashMap<Character,Character> map = new HashMap<>();
        
        for(int i=0 ; i<s.length() ; i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else if(map.containsValue(t.charAt(i)))
                return false;
            else {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
        
    }
}

