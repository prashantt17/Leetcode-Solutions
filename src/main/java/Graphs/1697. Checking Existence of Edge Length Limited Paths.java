class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int len = queries.length;
        int[][] qWithIds = new int[len][4];
        int j = 0;
        for(int[] query: queries){
            qWithIds[j]=new int[]{j,query[0], query[1], query[2]};
            j++;
        }
        Arrays.sort(edgeList, (a, b)->a[2]-b[2]);
        Arrays.sort(qWithIds, (a, b)->a[3]-b[3]);
        boolean[] result = new boolean[len];
        int edge = 0;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < len; i++){
            int limit = qWithIds[i][3];
            while(edge <edgeList.length && edgeList[edge][2]<limit){
                uf.union(edgeList[edge][0], edgeList[edge][1]);
                edge++;
            }
            result[qWithIds[i][0]]=(uf.find(qWithIds[i][1]) == uf.find(qWithIds[i][2]));
        }
        return result;
    }
}
class UnionFind{
    int[] root;
    int[] rank;
    UnionFind(int n){
        root = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for(int i = 0; i< n; i++)
            root[i]=i;
    }
    int find(int v){
        if (root[v] == v)
            return v;
        return find(root[v]);
    }
    void union(int v1, int v2){
        int ar1 = find(v1);
        int ar2 = find(v2);
        if (ar1!=ar2){
            if (rank[ar1]>=rank[ar2]){
                root[ar2]=ar1;
                rank[ar1]++;
            }else{
                root[ar1]=ar2;
                rank[ar2]++;
            }
        }
    }
}
