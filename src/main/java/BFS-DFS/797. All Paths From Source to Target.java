class Solution {
    static List<List<Integer>> list=new ArrayList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean visited[]=new boolean[graph.length];
        fun(graph,new ArrayList(),0,graph.length-1,visited);
        List<List<Integer>> xx=new ArrayList(list);
        list.clear();
        return xx;
    }
    static void fun(int graph[][],List<Integer> l,int src,int dest,boolean visited[]){
        if(src==dest)
        {
            l.add(dest);
            list.add(new ArrayList(l));
            l.remove(l.size()-1);
        }
        visited[src]=true;
        l.add(src);
        for(int nbr:graph[src])
        {
            if(visited[nbr]==false)
                fun(graph,l,nbr,dest,visited);
        }
        visited[src]=false;
        l.remove(l.size()-1);
    }
}
