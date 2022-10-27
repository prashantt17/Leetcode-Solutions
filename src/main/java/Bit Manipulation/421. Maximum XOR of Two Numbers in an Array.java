class Solution{
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) return 0; 
        Trie root = new Trie();
        int max = 0;
        
        for(int num: nums) {
            Trie current = root, complement = root;
            int value = 0;
            
            for(int i = 31; i >= 0; i --) {
                int bit = (num >>> i) & 1;
                
                if(current.children[bit] == null) current.children[bit] = new Trie(); 
                current = current.children[bit];
                
                if(complement.children[1-bit] != null) {complement = complement.children[1-bit]; value += (1<<i);}
                else complement = complement.children[bit];
            }
            max = Math.max(max, value);
        }
        return max;
    }
}

class Trie {
        Trie[] children;
        public Trie() { children = new Trie[2];}
}
