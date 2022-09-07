class Solution {
    public int checkWays(int[][] pairs) {
        int MAX = 501;
        Node[] map = new Node[MAX];
        Arrays.setAll(map, o -> new Node(o));
        for (int[] p : pairs){ 
            int u = p[0]-1;
            int v = p[1]-1;
            map[u].bit.set(u); map[u].bit.set(v);
            map[v].bit.set(u); map[v].bit.set(v);
        }
        int[] count = new int[MAX];
        for (int i = 0; i < MAX; i++){ 
            count[map[i].idx]=map[i].bit.cardinality();
        }
        Arrays.sort(map, Comparator.comparingInt(o -> -count[o.idx]));
        int sz = 0;
        int ans = 1;
        while(!map[sz].bit.isEmpty()){
            sz++;
        }
        List<Node> prev = new ArrayList<>();
        for (int i = 0; i < sz; i++){
            Node parent = findParent(prev, map[i].bit); 
            if (parent == null && count[map[i].idx] != sz){ 
                return 0;
            }
            if (parent != null){ 
                BitSet tmp = (BitSet)map[i].bit.clone();
                tmp.and(parent.bit);
                int m = tmp.cardinality();
                if (m!=count[map[i].idx]){ 
                    return 0;
                }
                if (m==count[parent.idx]){ 
                    ans=2;
                }
            }
            prev.add(map[i]);
        }
        return ans;
    }

    private Node findParent(List<Node> prev, BitSet cur){
        for (int i = prev.size()-1; i>=0; i--){
            if (cur.get(prev.get(i).idx))
                return prev.get(i);
        }
        return null;
    }

    private class Node {
        BitSet bit = new BitSet();
        int idx;
        Node (int idx){
            this.idx=idx;
        }
    }
}
