class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int dirX[]={-1,0,1,0};
        int dirY[]={0,1,0,-1};
        pq.add(new int[]{0,0,grid[0][0]});
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        vis[0][0]=true;
        int maxTime=Integer.MIN_VALUE;
        int n=grid.length;
        
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int i=0;i<size;i++){
                int temp[]=pq.remove();
                int x=temp[0];
                int y=temp[1];
                int t=temp[2];
                maxTime=Math.max(maxTime,t);
                if(x==n-1 && y==n-1) return maxTime;
                for(int j=0;j<4;j++){
                    int a=x+dirX[j];
                    int b=y+dirY[j];
                    if(a<0 || a>=grid.length || b<0 || b>=grid[0].length
                      || vis[a][b]) continue;
                    pq.add(new int[]{a,b,grid[a][b]});
                    vis[a][b]=true;
                }
            }
        }
        return 0;
    }
}
