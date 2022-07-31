/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

*/

class Solution {
    public int characterReplacement(String s, int k) {
        
        if(k==s.length() || k-1==s.length()){
            return s.length();
        }
        
        HashMap<Character, Integer> map=new HashMap<>();

        int l=0,size=0,freq=0;

        for(int i=0;i<s.length();i++){
            if(!(map.containsKey(s.charAt(i)))){
                map.put(s.charAt(i),1);
            }
            else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            freq=Math.max(freq,map.get(s.charAt(i)));
            if(i-l+1-freq > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }

            size=Math.max(size,i-l+1);
        }
        return size;
    }
}

