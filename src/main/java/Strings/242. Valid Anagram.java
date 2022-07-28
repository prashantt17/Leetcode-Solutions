/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

*/

class Solution {
    public boolean isAnagram(String s, String t) {
     
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] arr = new int[26];
        
        for (int i = 0 ; i < s.length() ; i++) {
            int index = s.charAt(i) - 97;
            arr[index] += 1;
        }
        
        for (int j = 0 ; j < t.length() ; j++) {
            int index = t.charAt(j) - 97;
            
            if (arr[index] == 0) {
                return false;
            }
            
            arr[index] -= 1;
        }
        
        return true;
    }
}

