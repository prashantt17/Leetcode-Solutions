class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
         int n=passingFees.length;
        List<List<int[]>>gr=new ArrayList<>();
        
        for(int i=0;i<n;i++)
            gr.add(new ArrayList<>());
        
        for(int[]edge:edges){
           gr.get(edge[0]).add(new int[]{edge[1],edge[2]});
           gr.get(edge[1]).add(new int[]{edge[0],edge[2]});    
        }
        
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int[]time=new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[0]=0;
        
        pq.add(new int[]{0,passingFees[0],0});
        
        
        while(pq.size() > 0){
            int[]tmp=pq.remove();
            
            
            if(tmp[2] > maxTime)continue;
            
            if(tmp[0]==n-1)return tmp[1];
              
           
            for(int[]child:gr.get(tmp[0])){
                
                     if(time[child[0]] > tmp[2]+child[1]){  
                       time[child[0]]=tmp[2]+child[1];
                       int c=tmp[1]+passingFees[child[0]];
                        
                      pq.add(new int[]{child[0],c,time[child[0]]});
                }
            }

        }
        
        return -1;
    }
}
