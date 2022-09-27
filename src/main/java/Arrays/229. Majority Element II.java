class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int num1 = -1;
        int num2 = -1;
        int n = nums.length;
        for (int elem:nums){
            
            if (elem == num1) cnt1++;
            else if (elem == num2) cnt2++;
            else if (cnt1 == 0){
                cnt1 = 1;
                num1 = elem;
            }
            else if (cnt2 == 0){
                cnt2 = 1;
                num2 = elem;
            }
            else {
                cnt1--;
                cnt2--;
            }
            
        }
        int count1 = 0;
        int count2 = 0;
        List<Integer> list = new ArrayList<>();
		for (int i=0;i<n;i++){
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
        }
		if (count1 > n/3) list.add(num1);
        if (count2 > n/3) list.add(num2);
        return list;
    }
}
