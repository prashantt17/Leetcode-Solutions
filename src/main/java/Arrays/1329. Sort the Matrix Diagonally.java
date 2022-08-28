class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
    int n=mat.length;
        int count=0;
        int m=mat[0].length;
        int i=0,k=0;

         while(count<m+n){
             if(i==n-1&&k<m){++k;}
             if(i!=n-1){++i;}
             
             pass(mat,n-1-i,k,n,m);count++;
         }
        return mat;
    }
    public void pass(int [][]a,int row,int col,int n,int m){
 
       
        int []arr=new int [101]; 
        int i=row,j=col;
        while(row<n&&col<m){
            arr[a[row++][col++]]++;
        }
 
       for(int k=0;k<101;k++){
           if(arr[k]>0){
               while(arr[k]!=0){
               a[i++][j++]=k;
                   --arr[k];
           }
           }
       } 
    }
}
