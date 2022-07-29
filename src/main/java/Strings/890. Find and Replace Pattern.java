/*
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
*/

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < words.length ; i++) {
            String word = words[i];
            
            boolean flag = getCompareStringCheck(word, pattern);
            if (flag) {
                list.add(word);
            }
        }
       
        return list;
    }
    
   public boolean getCompareStringCheck(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.indexOf(str1.charAt(i)) != str2.indexOf(str2.charAt(i))) {
              return false;  
            } 
        }
        return true;
    }
}

