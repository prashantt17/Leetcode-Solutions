class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int n = stamp.length();
        int m = target.length();
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] visited = new boolean[m];
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (count < m) {
            boolean found = false;
            for (int i = 0; i <= m - n; i++) {
                if (!visited[i] && canTransform(s, t, i)) {
                    found = true;
                    visited[i] = true;
                    count += replace(t, i, n, '*');
                    res.add(i);
                }
            }
            if (!found) return new int[0];
        }
        Collections.reverse(res);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;       
    }
    private boolean canTransform(char[] s, char[] t, int start) {
        for (int i = 0; i < s.length; i++) {
            if (t[start + i] != '*' && t[start + i] != s[i]) return false;
        }
        return true;
    }
    private int replace(char[] t, int start, int n, char c) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (t[start + i] != c) {
                t[start + i] = c;
                count++;
            }
        }
        return count;
        
    }
}
