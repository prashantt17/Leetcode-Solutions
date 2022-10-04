class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        int len = digits.length;
        for (int j = len - 1; j >= 0; j--) {
            if (digits[j] == 9) {
                sum += 1;
                digits[j] = 0;
            } else {
                break;
            }
        }
        if (sum == digits.length) {
            int[] rt = new int[digits.length + 1];
            rt[0] = 1;
            return rt;
        }
        digits[len - 1 - sum] = digits[len - 1 - sum] + 1;
        return digits;
    }
}
