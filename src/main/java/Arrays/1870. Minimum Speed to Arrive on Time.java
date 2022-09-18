class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int min = 1, max = 10000000, res = -1;
        for(int d: dist) max = Math.max(max, d);
        
        while(min <= max){
            int mid = min + (max - min)/2;
            if(isPossible(mid, dist, hour)) {
                res = mid;
                max = mid-1;
            }else min = mid + 1;
        }
        return res;
    }
    private boolean isPossible(int speed, int[] dist, double hour){
        double curHour = 0;
        for(int d: dist){
            curHour += Math.ceil((1.0*d)/speed);
        }
        curHour -= Math.ceil((1.0*dist[dist.length-1])/speed);
        curHour += (1.0*dist[dist.length-1])/speed;
        return curHour <= hour;
    }
}
