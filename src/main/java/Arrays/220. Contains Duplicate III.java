class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> ts = new TreeSet<>();

		for(int i=0; i<=indexDiff && i<nums.length; i++) {
			Long left = ts.floor((long)nums[i]);
			Long right = ts.ceiling((long)nums[i]);
			if(left != null && (long)nums[i] - left <= valueDiff) return true;
			if(right != null && right - (long)nums[i] <= valueDiff) return true;

			ts.add((long)nums[i]);
		}

		for(int i=indexDiff+1; i<nums.length; i++){
			ts.remove((long)nums[i-indexDiff-1]);

			Long left = ts.floor((long)nums[i]);
			Long right = ts.ceiling((long)nums[i]);
			if(left != null && (long)nums[i] - left <= valueDiff) return true;
			if(right != null && right - (long)nums[i] <= valueDiff) return true;

			ts.add((long)nums[i]);
		}

		return false;
    }
}
