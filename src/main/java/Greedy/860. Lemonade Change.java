class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) return false;
        
        int fives = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
                continue;
            } else if (bill == 10 && fives != 0) {
                fives--;
                tens++;
                continue;
            } else if (bill == 20) {
                if (tens != 0 && fives != 0) {
                    tens--;
                    fives--;
                    continue;
                } else if (fives >= 3) {
                    fives -= 3;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
