class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;

        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (helper(s, p, removable, mid)) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res + 1;
    }

    private boolean helper(String s, String p, int[] removable, int mid) {
        char[] chars = s.toCharArray();
        for (int i = mid; i >= 0; i--) {
            chars[removable[i]] = ' ';
        }

        int idP = 0;
        int idS = 0;
        while (idP < p.length() && idS < s.length()) {
            if (p.charAt(idP) == chars[idS]) {
                idS++;
                idP++;
            } else {
                idS++;
            }
        }
        return idP >= p.length();
    }
}
