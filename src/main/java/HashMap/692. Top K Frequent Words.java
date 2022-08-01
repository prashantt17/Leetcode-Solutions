/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
*/


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
          Map<String, Integer> freqMap=new HashMap<>();
        for(String str: words){
            freqMap.put(str,freqMap.getOrDefault(str,0)+1);
        }

        TreeMap<Integer, List<String>> sortedMap=new TreeMap<>((i1, i2)->{return i2-i1;});
        for(Map.Entry<String, Integer> entry:freqMap.entrySet()){
            List<String> list=sortedMap.getOrDefault(entry.getValue(),new ArrayList<>());
            list.add(entry.getKey());
            sortedMap.put(entry.getValue(), list);
        }
        int i=0;
        List<String> ans=new ArrayList<>();
        for(List<String> strs:sortedMap.values()){
            Collections.sort(strs);
            for(String str:strs){
                ans.add(str);
                i++;
                if(i==k)break;
            }
            if(i==k)break;
        }
        return ans;
    }
}
