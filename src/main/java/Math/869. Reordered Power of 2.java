class Solution {
    public boolean reorderedPowerOf2(int n) {
        int Count[] = Count(n);
        int power = 1;
        for (int i = 0; i < 31; i++) {
            int[] PowerCount = Count(power);
            if (Equal(Count, PowerCount)) {
                return true;
            }
            power *= 2;
        }
        return false;
    }

    private int[] Count(int n) { 
        int Count[] = new int[10];
        while (n != 0) {
            Count[n % 10]++;
            n /= 10;
        }
        return Count;
    }

    private boolean Equal(int ar1[], int ar2[]) {
        for (int i = 0; i < ar2.length; i++) {
            if (ar1[i] != ar2[i]) {
                return false;
            }
        }
        return true;
    }
}
