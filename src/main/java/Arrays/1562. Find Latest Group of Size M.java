class Solution {
    public int findLatestStep(int[] arr, int m) {
        if(m == arr.length) return arr.length;
        
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] - b[0]); 
        set.add(new int[]{1, arr.length});
        
        for(int i = arr.length - 1; i >= 0; i--) {
            int[] cur = set.floor(new int[]{arr[i]});
           
            
            if(cur == null || arr[i] > cur[1]) continue;
            set.remove(cur);
            
            if(arr[i] - cur[0] == m || cur[1] - arr[i] == m) return i;
            
            if(arr[i] - cur[0] > m) set.add(new int[]{cur[0], arr[i] - 1});
            if(cur[1] - arr[i] > m) set.add(new int[]{arr[i] + 1, cur[1]});
        }
        
        return -1;
    }
}
