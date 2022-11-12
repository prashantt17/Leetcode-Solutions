class Solution {
    public int minAddToMakeValid(String s) {
        int now = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                now++;
            } else {
                if (now != 0) now--;
                else res++;
            }
        }
        return res + now;
    }
}
