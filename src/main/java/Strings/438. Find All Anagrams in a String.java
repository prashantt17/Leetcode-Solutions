/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
    if (s == null || s.length() == 0 || p.length() == 0 || p.length() == 0)
            return new LinkedList<>();
        int[] arr = new int[26];
        int count = 0;
        for (int i=0;i<p.length();++i) {
            arr[p.charAt(i) - 'a']++;
            ++count;
        }

        List<Integer> res = new LinkedList<>();
        for (int i=0;i<s.length();) {
            if (arr[s.charAt(i)-'a'] > 0)
                i = helper(s, arr, count, i, i+p.length(), res);
            else ++i;
        }
        return res;
    }

    private int helper(String s, int[] arr, int count, int start, int end, List<Integer> res) {
        int[] temp = arr.clone();
        for (int i=start;i<end && i<s.length();++i) {
            if (temp[s.charAt(i)-'a'] == 0)
                return start+1;
            else {
                temp[s.charAt(i) - 'a']--;
                --count;
            }
        }
        if (count == 0) {
            res.add(start);
            return slidingWindow(s, start, end, res, arr);
        } else
            return start+1;
    }

    private int slidingWindow(String s, int start, int end, List<Integer> res, int[] arr) {
        while (end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                res.add(start + 1);
                ++start;
                ++end;
            } else
                break;
        }
        if (end < s.length()) {
            if (arr[s.charAt(end)-'a'] > 0)
                return start+2;
            else
                return end+1;
        }
        return end;
    }

}
