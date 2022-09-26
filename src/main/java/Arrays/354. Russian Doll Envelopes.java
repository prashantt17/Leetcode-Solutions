class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
           }
        });
        int[] heights = new int[n];
        for(int i = 0; i < n; i++){
            heights[i] = envelopes[i][1];
        }
        return findLongestIncreasingSubsequence(heights);
    }
    public int findLongestIncreasingSubsequence(int[] nums){
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(list.isEmpty() || list.get(list.size() - 1) < nums[i]){
                list.add(nums[i]);
            }else if (!list.isEmpty() && list.get(list.size() - 1) > nums[i]){
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
    public int binarySearch(List<Integer> list, int target){
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(list.get(mid) < target){
                left = mid + 1;
            }else if(list.get(mid) == target){
                return mid;
            }else{
                if(mid == 0 || (mid >= 1 && list.get(mid-1) < target)){
                    return mid;
                }
                right = mid - 1;
            }
        }
        if(list.get(left) >= target){
            return left;
        }
        return -1;
    }
}
