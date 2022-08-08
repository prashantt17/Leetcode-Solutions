class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int accuSum = 0;
        int total = 0;

        for (int num : nums) {
            accuSum += num;
            int complement = accuSum - k;
            int complementCount = map.getOrDefault(complement, 0);
            total += complementCount;
            int accSumCount = map.getOrDefault(accuSum, 0);
            map.put(accuSum, accSumCount + 1);
        }
        
        return total;
    }
}
