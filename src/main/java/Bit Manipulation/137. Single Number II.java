class Solution {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int x: nums) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}
		int ans = 0;
		for (int x: hm.keySet()) {
			if (hm.get(x) == 1) {
				ans = x;
				break;
			}
		}
		return ans;
	}
}
