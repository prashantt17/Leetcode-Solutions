class Solution {
    public int removeStones(int[][] stones) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=stones.length;
        
        for(int i=0;i<n;i++){
            int stone[]=stones[i];
            map.putIfAbsent(stone[0]+1,i);
            map.putIfAbsent(-1*(stone[1]+1),i);
        }
        
        UnionFind uf=new UnionFind(n);

        for(int i=0;i<n;i++){
            int stone[]=stones[i];
            if(map.containsKey(stone[0]+1)){
                uf.join(i,map.get(stone[0]+1));
            }
            if(map.containsKey(-1*(stone[1]+1))){
                uf.join(i,map.get(-1*(stone[1]+1)));
            }
        }
        
        Set<Integer> set=new HashSet<>();
        
        for(int i=0;i<n;i++){
            set.add(uf.find(i));
        }
        
        return n-set.size();
    }
}

class UnionFind {
    int parent[];
    int rank[];
    
    public UnionFind(int n) {
        parent=new int[n];
        rank=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    
    public int find(int i) {
        if(parent[i]!=i){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
    
    public void join(int a, int b){
        int rootA=find(a);
        int rootB=find(b);
        
        if(rootA!=rootB){
            if(rank[rootA]<rank[rootB]){
                parent[rootA]=rootB;
            } else {
                parent[rootB]=rootA;
                if(rank[rootA]==rank[rootB]){
                    rank[rootA]++;
                }
            }
        }
    }
}
