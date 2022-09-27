class Solution {
    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n+1];
        int counter = 0;
        if(n<2)return 0;
        for(int i=2;i*i<=n;i++){
            if(!isPrime[i]){
                for(int j = i*i;j<=n;j+=i){
                    if(isPrime[j]!=true){
                        counter++;
                        isPrime[j] = true;
                    }
                }
            }
        }
        if(!isPrime[n]){
            return ((n-1)-counter)-1;
        }
        else{
            return (n-1)-counter;
        }
    }
}
