class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer>fullMap = new HashMap(); 
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        List<Integer>dryDays = new ArrayList();
        for (int i = 0; i < n; i++) 
        {
            int lakeIdx = rains[i]; 
            if (lakeIdx == 0) { dryDays.add(i); continue; }  
            
            if (fullMap.containsKey(lakeIdx)) 
            {
                int lastDrenchedDay = fullMap.get(lakeIdx); 
                int nearestDryDay = getNearestDryDay(dryDays, lastDrenchedDay);
                
                if (nearestDryDay == -1) return new int[]{};
                ans[nearestDryDay] = lakeIdx;
            }
            fullMap.put(lakeIdx, i);
            ans[i] = -1;
        }
        
        return ans;
    }
    
    int getNearestDryDay(List<Integer> dryDays, int targetDay) 
    {
        int low = 0, high = dryDays.size() - 1;
        int ans = -1, index = -1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int currDay = dryDays.get(mid);
            if (currDay > targetDay) { index = mid; ans = currDay; high = mid - 1; }
            else low = mid + 1;
        }
        if (index != -1) dryDays.remove(index);
        return ans;
    }
}
