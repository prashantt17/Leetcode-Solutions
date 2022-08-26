class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int sum = 1;
        for(int i=1;i<=n;i++){
            int current = 9;
            if(i==1){
                current = 9;
            }else if(i==2){
                current = 81;
            }else{
                current = 81;
                for(int j=3;j<=i;j++){
                    current=current*(10-(j-1));
                }
            }
            sum+=current;
        }
        
        return sum;
    }
}
