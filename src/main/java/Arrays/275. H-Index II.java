class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int left = 1;
        int right = citations.length;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[citations.length - mid] >= mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
