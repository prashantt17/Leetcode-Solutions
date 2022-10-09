class Solution {
    int[] color;
    List<Integer> adj[];
    int N;
    public int[] gardenNoAdj(int n, int[][] edges) 
    {
        N = n;
        adj = new ArrayList[N];
        for(int i=0;i<N;i++)
            adj[i] = new ArrayList<>();
        
        color = new int[N];
        
        for(int[] e : edges)
        {
            adj[e[0]-1].add(e[1]-1);
            adj[e[1]-1].add(e[0]-1);
        }
        
        backTrack(0);
        
        return color;
    }
    
    public boolean backTrack(int u)
    {
        if(u == N)
            return true;
        
        for(int c = 1; c <= 4; c++)
        {
            if(isValid(u, c))
            {
                color[u] = c;
                
                if(backTrack(u+1))
                    return true;
                
                color[u] = 0;
            }
        }
        
        return false;
    }
    
    public boolean isValid(int u, int c)
    {
        for(int v : adj[u])
        {
            if(c == color[v])
                return false;
        }
        
        return true;    
    }
}
