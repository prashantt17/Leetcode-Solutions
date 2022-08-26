class Solution {
    public int integerReplacement(int n) {
        int steps=0;
        long n1=(long) n;
        while(n1!=1)
        {
            if(n1%2==0)
                n1/=2;
            else{
                long temp=(n1-1)/2;
                if(temp==1 || temp%2==0)
                {
                    n1=n1-1;
                }
                else{
                    n1=n1+1;
                }
            }
            steps++;
        }
        return steps;
    }
}
