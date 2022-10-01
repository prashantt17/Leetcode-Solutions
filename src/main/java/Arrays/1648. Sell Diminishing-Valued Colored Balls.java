class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
    Arrays.sort(inventory);
        long ans = 0;
        int n = inventory.length-1;
        long count = 1;
        while(orders > 0){
            if(n > 0 && inventory[n] - inventory[n-1] > 0 && orders >= count * (inventory[n] - inventory[n-1])){
                ans += count * sumFromNtoX(inventory[n], inventory[n-1]);
                orders -= count * (inventory[n] - inventory[n-1]);
            }else if(n == 0 || inventory[n] - inventory[n-1] > 0){
                long a = orders / count;
                ans += count * sumFromNtoX(inventory[n], inventory[n]-a);
                long b = orders % count;
                ans += b * (inventory[n]-a);
                orders = 0;
            }
            ans %= 1000000007;
            n --;
            count ++;
        }
        return (int)ans;
    }
    
    private long sumFromNtoX(long n, long x){
        return (n * (n+1))/2 - (x * (x+1))/2;
    }
}
