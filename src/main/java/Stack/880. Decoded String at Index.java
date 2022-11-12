class Solution {
    public String decodeAtIndex(String s, int k) {
        int i;
        long N = 0;
        for (i = 0; N < k; i++) {
            N = Character.isDigit(s.charAt(i)) ? N * (s.charAt(i) - '0') : N + 1;
        }
        for (i--; i > 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                N /= s.charAt(i) - '0';
                k %= N;
            }
            else {
                if (k % N == 0) {
                    break;
                }
                N--;
            }
        }
        return Character.toString(s.charAt(i));
    }
}
