class Solution {
    public int findRotateSteps(String ring, String key) {
         Map<Character, TreeSet<Integer>> locMap = new HashMap<>();
        for (int i = 0; i < ring.length(); i++){
            locMap.computeIfAbsent(ring.charAt(i), o->new TreeSet<>()).add(i);
        }
        return dfs(0, 0, locMap, key, new int[key.length()][ring.length()]);
    }

    private int dfs(int cur, int where, Map<Character, TreeSet<Integer>> locMap, String key, int[][] memo){
        if (cur==key.length()){ 
            return 0;
        }
        if (memo[cur][where]>0){ 
            return memo[cur][where];
        }
        TreeSet<Integer> idx = locMap.get(key.charAt(cur));
        if (idx.contains(where)){ 
            return memo[cur][where]=dfs(cur+1, where, locMap, key, memo)+1;
        }
        Integer hi = idx.higher(where); 
        Integer lo = idx.lower(where); 
        if (hi == null){ 
            hi = idx.first();
        }
        if (lo == null){ 
            lo = idx.last();
        }
        int hcost = dfs(cur+1, hi, locMap, key, memo) + (hi>where? hi-where:memo[0].length-where+hi);
        int lcost = dfs(cur+1, lo, locMap, key, memo) + (lo<where? where-lo:where+memo[0].length-lo);
        return memo[cur][where]=Math.min(hcost, lcost)+1;
    
    }
}
