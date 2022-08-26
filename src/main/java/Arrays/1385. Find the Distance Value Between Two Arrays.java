class Solution {
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		Arrays.sort(arr2);
		int count = 0;
		boolean isTrue = false;
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int i = 0; i<arr1.length; i++) {
			for (int j = 0; j<arr2.length; j++) {
				if (Math.abs(arr1[i] - arr2[j])<= d) {
					isTrue = true;
					break;
				}
			}
			if (!isTrue) {
				count++;
			}
			isTrue = false;
		}
		return count;
	}
}
