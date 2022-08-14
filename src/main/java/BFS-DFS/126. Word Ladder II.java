class Solution {
    ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
    List<List<Integer>> paths = new ArrayList<>();
    ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int w = wordList.size();
        int i, j;
        
        for(i=0;i<w+1;i++){
            adj.add(new ArrayList<>());
        }
        
        for(i=0;i<w;i++){
            if(checkSingleDiff(beginWord, wordList.get(i)) == 1){
                addEdge(0, i+1);
            }
        }
        
        for(i=0;i<w;i++){
            for(j=i+1;j<w;j++){
                if(checkSingleDiff(wordList.get(i), wordList.get(j)) == 1){
                    addEdge(i+1, j+1);
                }
            }
        }
           
        int beginWordInd = 0;
        int endWordInd = -1;
        for(i=0;i<w;i++){
            if(wordList.get(i).equals(endWord)){
                endWordInd = i+1;
                break;
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        if(endWordInd != -1){ 
            ans = getShortestSequences(beginWordInd, endWordInd, w+1, wordList, beginWord);
        }
        
        return ans;
    }
    
    private List<List<String>> getShortestSequences(int src, int dest, int vertices, List<String> wordList, String beginWord){
        ArrayList<Integer> path = new ArrayList<>();
        
        int i, j;
        for(i=0;i<vertices;i++){
            parent.add(new ArrayList<>());
        }
        
        BFS(vertices, src, wordList);
        
        getShortestSequencesUtil(path, vertices, dest);
        
        // System.out.println("Size of paths is " + paths.size());
        for(i=0;i<paths.size();i++){
            Collections.reverse(paths.get(i));
            paths.set(i, paths.get(i));
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(i=0;i<paths.size();i++){
            List<Integer> p = paths.get(i);
            ArrayList<String> pp = new ArrayList<>();
            for(j=0;j<p.size();j++){
                if(p.get(j) == 0){
                    pp.add(beginWord);
                }
                else{
                    pp.add(wordList.get(p.get(j) - 1));   
                }
            }
            ans.add(pp);
        }
        
        return ans;
    }
    
    private void getShortestSequencesUtil(ArrayList<Integer> path, int vertices, int dest){
        if(dest == -1){
            paths.add(new ArrayList<>(path));
            return;
        }
        
        for(int p : parent.get(dest)){
            path.add(dest);
            getShortestSequencesUtil(path, vertices, p);
            path.remove(path.size() - 1);
        }
    }
    
    private void BFS(int vertices, int src, List<String> wordList){
        int shortestDist[] = new int[vertices];
        Arrays.fill(shortestDist, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        parent.get(src).clear();
        parent.get(src).add(-1);
        shortestDist[src] = 0;
        
        while(q.isEmpty() == false){
            int u = q.poll();
            for(int v : adj.get(u)){
                if(shortestDist[u] + 1 < shortestDist[v]){
                    shortestDist[v] = shortestDist[u] + 1;
                    q.offer(v);
                    parent.get(v).clear();
                    parent.get(v).add(u);
                }
                else if(shortestDist[u] + 1 == shortestDist[v]){
                    parent.get(v).add(u);
                }
            }
        }
        
     
    }
    
    private void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    private int checkSingleDiff(String a, String b){
        int i;
        int count = 0;
        for(i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        
        return count;
    }
}
