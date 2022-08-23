class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int e: nums) 
            hm.put(e, hm.getOrDefault(e, 0) + 1);
        PriorityQueue<Value> pq = new PriorityQueue();
        for (Integer key: hm.keySet()) {
            if (pq.size() < k ) pq.add(new Value(key, hm.get(key)));
            else {
                while (pq.size() >= k && pq.peek().freq < hm.get(key)) {
                    pq.poll();
                }
                if (pq.size() < k) pq.add(new Value(key, hm.get(key)));
            }            
        }
        int ans[] = new int[k];
        int i = 0;
        for (Value v: pq) {
            ans[i++] = v.val;
        }
        return ans;
    }
}

class Value implements Comparable<Value>{
    int val, freq;
    
    public Value (int a, int b) {
        val = a;
        freq = b;
    }
    
    @Override
    public int compareTo(Value v2) {
        if (this.freq > v2.freq) return 1;
        else if (this.freq < v2.freq) return -1;
        else return this.freq-v2.freq;
    }
    
    @Override
    public String toString() {
        return "{val: " + this.val + ", freq: " + this.freq + "}";
    }
}
