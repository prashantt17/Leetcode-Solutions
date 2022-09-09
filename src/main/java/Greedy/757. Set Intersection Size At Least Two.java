class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int ans = 0;
        int max = -1;
        int secondMax = -1;

        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        for (int[] interval : intervals) {
          final int a = interval[0];
          final int b = interval[1];
          if (max >= a && secondMax >= a)
            continue;
          if (max >= a) { 
            secondMax = max;
            max = b; 
            ans += 1;
          } else {   
            max = b; 
            secondMax = b - 1; 
            ans += 2;
          }
        }

        return ans;
    }
}
