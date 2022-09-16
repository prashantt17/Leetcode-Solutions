class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char p1 = '$', p2 = '$';
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2) {
                if (++count == 1) {
                    p1 = c2;
                    p2 = c1;
                } else if (count > 2 || c1 != p1 || c2 != p2) {
                    return false;
                }
            }
        }
        return (count & 1) == 0;
    }
}
