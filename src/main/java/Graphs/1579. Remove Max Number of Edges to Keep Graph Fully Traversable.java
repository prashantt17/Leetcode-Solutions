class Solution {
    int[] ParentAlc;
    int[] ParentBob;
    
    int EdgeAlc = 0;
    int EdgeBob = 0;
    int EdgeRem = 0;
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b)->{return b[0]-a[0];});
        ParentAlc = new int[n+1]; ParentBob = new int[n+1];
        for(int i=0; i<(n+1); i++){
            ParentAlc[i] = ParentBob[i] = i;
        }
        
        for(int[] E: edges){
            if(E[0] == 3){
                boolean UnionAlc = Union(E[1], E[2], ParentAlc);
                boolean UnionBob = Union(E[1], E[2], ParentBob);
                if(UnionAlc){EdgeAlc++;}
                if(UnionBob){EdgeBob++;}
                if(!UnionAlc && !UnionBob){EdgeRem++;}
            } else if(E[0] == 2){
                boolean UnionBob = Union(E[1], E[2], ParentBob);
                if(UnionBob){EdgeBob++;}
                else{EdgeRem++;}
            } else if(E[0] == 1){
                boolean UnionAlc = Union(E[1], E[2], ParentAlc);
                if(UnionAlc){EdgeAlc++;}
                else{EdgeRem++;}
            }
        } if((EdgeAlc == (n-1)) && (EdgeBob == (n-1))){
            return EdgeRem;
        } else{
            return -1;
        }
    }
    
    int find(int Node, int[] Par){
        if(Node == Par[Node]){
            return Node;
        } return Par[Node] = find(Par[Node], Par);
    }
    
    boolean Union(int x, int y, int[] Par){
        int Px = find(x, Par);
        int Py = find(y, Par);
        if(Px != Py){
            Par[Py] = Px;
            return true;
        } else{
            return false;
        }
    }
}
