class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character,Integer> freq = new HashMap<>();
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->{
            return a.getValue()!=b.getValue() ? b.getValue()-a.getValue():b.getKey()-a.getKey();
        });
        for(Map.Entry<Character,Integer> entry:freq.entrySet()){
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder(n);
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.remove();
            int fr = entry.getValue();
            char c = entry.getKey();
            while(fr-->0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
