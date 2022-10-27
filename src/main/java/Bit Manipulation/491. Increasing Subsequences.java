class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        gen(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void gen(int cur, int[] nums, List<List<Integer>> ans, List<Integer> tmp){
        if (cur == nums.length){
            if (tmp.size() > 1){
                ans.add(new ArrayList<>(tmp));
            }
            return;
        }

        if (cur == 0 || tmp.isEmpty() || tmp.get(tmp.size() - 1) != nums[cur]){
            gen(cur + 1, nums, ans, tmp); // not-pick option
        }
        if (tmp.isEmpty() || tmp.get(tmp.size() - 1) <= nums[cur]){
            tmp.add(nums[cur]);
            gen(cur + 1, nums, ans, tmp); 
            tmp.remove(tmp.size() - 1);
        }
    }
}
