class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = (int)2e9;
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(ab, c);
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            long count = 0L + mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    private long gcd(long a, long b){
        return b == 0? a : gcd(b, a % b);
    }

    private long lcm(long a, long b){
        return a * b / gcd(a, b);
    
    }
}
