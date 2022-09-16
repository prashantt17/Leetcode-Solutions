class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         Arrays.sort(piles);
        if (h == piles.length) {
            return piles[piles.length - 1];
        }
        int lo = 0, hi = piles[piles.length - 1];
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (willFinish(mid, piles, h)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
    
    private boolean willFinish(int speed, int[] piles, int target) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
            if (hours > target) {
                return false;
            }
        }
        return true;
    }
}
