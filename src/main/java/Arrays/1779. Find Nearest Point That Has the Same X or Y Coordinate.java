class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE,index=0;
        for(int i=0;i<points.length;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            if(x==x1 || y==y1){
                if(Math.abs(x-x1)+Math.abs(y-y1)<min){
                    min=Math.abs(x-x1)+Math.abs(y-y1);
                    index=i;
                }
            }
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        
        return index;
    }
}
