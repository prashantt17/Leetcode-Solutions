class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int aXORb = 0;
        for (int n : nums) {
            aXORb ^= n;
        }

        int rightSetBit = aXORb & -aXORb;
        int a = 0;
        for (int n : nums) {
            if ((n & rightSetBit) != 0) {
                a ^= n;
            }
        }

        return new int[] {a, aXORb ^ a};
    }
}
