/*

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2

*/

class Solution {
  public int numMatchingSubseq(String s, String[] words) {
    int counter = 0;

    Map < String, Integer > map = new HashMap < > ();

    for (String str: words) {
      map.put(str, map.getOrDefault(str, 0) + 1);
    }

    for (Map.Entry < String, Integer > entry: map.entrySet()) {
      String key = entry.getKey();
      if (getSubsequenceCount(key, s)) {
        counter += entry.getValue();
      }
    }

    return counter;
  }

  public boolean getSubsequenceCount(String str1, String str2) {

    int i = 0;
    int j = 0;

    while (i < str1.length() && j < str2.length()) {
      if (str1.charAt(i) == str2.charAt(j)) {
        i++;
      }
      j++;
    }

    if (i == str1.length()) {
      return true;
    }

    return false;
  }
}
