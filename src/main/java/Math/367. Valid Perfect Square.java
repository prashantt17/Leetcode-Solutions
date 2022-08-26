class Solution {
    public boolean isPerfectSquare(int num) {
        int current = 1;
        while (num > 0) {
            num -= current;
            current += 2;
        }

        return (num == 0);
    }
}
