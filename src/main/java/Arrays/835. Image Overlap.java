class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int R1 = img1.length;
        int R2 = img2.length;
        int C1 = img1[0].length;
        int C2 = img2[0].length;
        int max = Integer.MIN_VALUE;
		
	    for(int r=0; r<R1+R2-1; r++){
            int i = R1-1 + Math.min(0, R2-1-r);
            int x = r + Math.min(0, R2-1-r);
            for(int c=0; c<C1+C2-1;  c++){
                int j = C1-1 + Math.min( 0 ,  C2-1-c);
                int y = c + Math.min(0 , C2-1-c);
                max = Math.max(max, overlap(img1,img2,i,j,x,y));
            }
        }
        return max;
    }
    
	int overlap(int[][] img1, int[][] img2, int i1,int j1, int i2, int j2){
        int count = 0;
        for(int i=i1,x=i2; i>=0 && x>=0; i--,x--){
            for(int j=j1, y=j2; j >=0 && y>=0 ; j--,y--){
                if(img1[i][j] == img2[x][y]){
                    if(img1[i][j]==1)
                        count++;
                }
            }
        }
        return count;
    
    }
}
