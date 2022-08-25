class Solution {
    public int minSwapsCouples(int[] row) {
     int[][] couples=new int[row.length/2][2];
        int i=0;
        while(i<row.length){
            couples[i/2][0]=row[i];
            i++;
            couples[i/2][1]=row[i];
            i++;
        }
        int swap=0;
        for(i=0;i<couples.length;i++){
            int first=couples[i][0];
            if(first%2==0){
                int required=first+1;
                swap=help(couples,required,i,swap);
            }
            else{
                int required=first-1;
                swap=help(couples,required,i,swap);
            }
        }
        return swap;
    }
    public static int help(int[][] couples,int required,int i,int swap){
        if(couples[i][1]!=required){
            for(int j=i+1;j<couples.length;j++){
                int a=couples[j][0];
                int b=couples[j][1];
                if(a==required){
                    int temp=couples[j][0];
                    couples[j][0]=couples[i][1];
                    couples[i][1]=temp;
                    swap++;
                    break;
                }
                if(b==required){
                    int temp=couples[j][1];
                    couples[j][1]=couples[i][1];
                    couples[i][1]=temp;
                    swap++;
                    break;
                }
            }
        }
        return swap;
       
    }
}
